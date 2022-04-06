package junit;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Matchers;

import static org.assertj.core.api.Assertions.allOf;
import static org.assertj.core.api.Assertions.anyOf;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.anyOf;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.ArgumentMatchers.matches;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.validation.constraints.Email;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;

import com.example.demo.login.domain.model.SignupForm;

@SpringBootTest
public class SignupFromTest {

	@Autowired
	Validator validator;

	private SignupForm testsignupForm = new SignupForm();

	@Test(expected = NullPointerException.class)
	public void testExceptionThrown() {
		String str = null;

		str.contains("a");
	}

	Pattern p = Pattern.compile("^$|^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[!-/:-@\\[-`{-~])[!-~]*");
	Matcher m = p.matcher("aA1!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~");
	Matcher pass = m;

	@Test
	public void No1_ユーザID_メールアドレスチェック() {
		testsignupForm.setUserId("abc@gmail.com");
		assertThat(testsignupForm.getUserId()
				.contains("^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9-]+(?:\\.[a-zA-Z0-9-]+)*$"));
	}

	@Test
	public void No2_ユーザID_全角アルファベット() {
		testsignupForm.setUserId("ａbc@gmail.com");
		assertThat(testsignupForm.getUserId()
				.contains("^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9-]+(?:\\.[a-zA-Z0-9-]+)*$"));
	}

	@Test
	public void No3_ユーザID_全角数字() {
		testsignupForm.setUserId("１abc@gmail.com");
		assertThat(testsignupForm.getUserId()
				.contains("^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9-]+(?:\\.[a-zA-Z0-9-]+)*$"));
	}

	@Test
	public void No4_ユーザID_全角記号() {
		testsignupForm.setUserId("／abc@gmail.com");
		assertThat(testsignupForm.getUserId()
				.contains("^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9-]+(?:\\.[a-zA-Z0-9-]+)*$"));
	}

	@Test
	public void No5_ユーザID_半角アルファベット() {
		testsignupForm.setUserId("abc@gmail.com");
		assertThat(testsignupForm.getUserId()
				.contains("^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9-]+(?:\\.[a-zA-Z0-9-]+)*$"));
	}

	@Test
	public void No6_ユーザID_半角数字() {
		testsignupForm.setUserId("1abc@gmail.com");
		assertThat(testsignupForm.getUserId()
				.contains("^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9-]+(?:\\.[a-zA-Z0-9-]+)*$"));
	}

	@Test
	public void No7_ユーザID_半角記号() {
		testsignupForm.setUserId("/abc@gmail.com");
		assertThat(testsignupForm.getUserId()
				.contains("[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9-]+(?:\\.[a-zA-Z0-9-]+)*$"));
	}
	// No8半角かなは半角かな自体が存在しないためテストは飛ばします。

	@Test
	public void No9＿ユーザID_半角カナ() {
		testsignupForm.setUserId("ｶﾅabc@gmail.com");
		assertThat(testsignupForm.getUserId()
				.contains("[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9-]+(?:\\.[a-zA-Z0-9-]+)*$"));

	}

	@Test
	public void No10＿ユーザID_全角かな() {
		testsignupForm.setUserId("かなabc@gmail.com");
		assertThat(testsignupForm.getUserId()
				.contains("[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9-]+(?:\\.[a-zA-Z0-9-]+)*$"));

	}

	@Test
	public void No11＿ユーザID_全角カナ() {
		testsignupForm.setUserId("カナabc@gmail.com");
		assertThat(testsignupForm.getUserId()
				.contains("[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9-]+(?:\\.[a-zA-Z0-9-]+)*$"));

	}

	@Test
	public void No12＿ユーザID_漢字() {
		testsignupForm.setUserId("仮名abc@gmail.com");
		assertThat(testsignupForm.getUserId()
				.contains("[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9-]+(?:\\.[a-zA-Z0-9-]+)*$"));

	}

	@Test
	public void No13＿パスワード_半角アルファベット() {
		testsignupForm.setPassword("aaaaaaaAAAAA");
		assertThat(testsignupForm.getPassword().matches("[0-9a-z.?/-]{8,20}"));

	}

	@Test
	public void No14＿パスワード_半角数字() {
		testsignupForm.setPassword("111111aaaaaaa");
		assertThat(testsignupForm.getPassword().matches("[0-9a-z.?/-]{8,20}"));

	}

	// No15の半角かなはそもそもない

	@Test
	public void No16＿パスワード_半角かな() {
		testsignupForm.setPassword("ｶﾅaaaaaaa");
		assertThat(testsignupForm.getPassword().matches("[0-9a-z.?/-]{8,20}"));
	}

	@Test
	public void No17＿パスワード_全角アルファベット() {
		testsignupForm.setPassword("ａａａａaaaaaa");
		assertThat(testsignupForm.getPassword().matches("[0-9a-z.?/-]{8,20}"));
	}

	@Test
	public void No18＿パスワード_全角数字() {
		testsignupForm.setPassword("１１１１１aaaaaa");
		assertThat(testsignupForm.getPassword().matches("^[0-9a-z.?/-]{8,20}"));
	}

	@Test
	public void No19＿パスワード_全角かな() {
		testsignupForm.setPassword("かなaaaaaa");
		assertThat(testsignupForm.getPassword().matches("^[0-9a-z.?/-]{8,20}"));
	}

	@Test
	public void No20＿パスワード_全角カナ() {
		testsignupForm.setPassword("カナaaaaaa");
		assertThat(testsignupForm.getPassword().matches("[0-9a-z.?/-]{8,20}"));
	}

	@Test
	public void No21＿パスワード_文字制限21字() {
		testsignupForm.setPassword("aaaaaaaaaaaaaaaaaaaaa");
		assertThat(testsignupForm.getPassword().matches("^[0-9a-z.?/-]{8,20}"));
	}

	@Test
	public void No22＿パスワード_文字制限20字() {
		testsignupForm.setPassword("aaaaaaaaaaaaaaaaaaaa");
		assertThat(testsignupForm.getPassword().matches("^[0-9a-z.?/-]{8,20}"));
	}

	@Test
	public void No23＿パスワード_文字制限19字() {
		testsignupForm.setPassword("aaaaaaaaaaaaaaaaaaa");
		assertThat(testsignupForm.getPassword().matches("^[0-9a-z.?/-]{8,20}"));
	}

	@Test
	public void No24＿パスワード_文字制限9字() {
		testsignupForm.setPassword("aaaaaaaaa");
		assertThat(testsignupForm.getPassword().matches("^[0-9a-z.?/-]{8,20}"));
	}

	@Test
	public void No25＿パスワード_文字制限8字() {
		testsignupForm.setPassword("aaaaaaaa");
		assertThat(testsignupForm.getPassword().matches("^[0-9a-z.?/-]{8,20}"));
	}

	@Test
	public void No26＿パスワード_文字制限7字() {
		testsignupForm.setPassword("aaaaaaa");
		assertThat(testsignupForm.getPassword().matches("^[0-9a-z.?/-]{8,20}"));
	}

}

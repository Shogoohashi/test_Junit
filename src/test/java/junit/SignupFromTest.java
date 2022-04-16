package junit;

import static org.junit.Assert.*;

import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.rules.TemporaryFolder;
import org.junit.rules.TestName;

import static org.assertj.core.api.Assertions.allOf;
import static org.assertj.core.api.Assertions.anyOf;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.anyOf;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import static org.mockito.ArgumentMatchers.matches;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.validation.constraints.Email;
import static org.hamcrest.Matchers.*;
import org.springframework.aop.support.MethodMatchers;
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
	private BindingResult bindingResult = new BindException(testsignupForm, "echoForm");


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
	public void No27＿誕生日_年月日() throws ParseException {
		testsignupForm.setBirthday  = new TestName();
//		SimpleDateFormat df = new SimpleDateFormat("yyyy/MM/dd");
		LocalDate TestName = LocalDate.of(2019, 8, 10);
		LocalDate TestBirthday = LocalDate.of(2019, 8, 10);
		assertThat(TestName.isEqual(TestBirthday));		
		
	}
	
	
	@Test
	public void No28＿誕生日_半角数字() throws ParseException {
		testsignupForm.setBirthday  = new TestName();
//		SimpleDateFormat df = new SimpleDateFormat("yyyy/MM/dd");
		LocalDate TestName = LocalDate.of(2019,8,10);
		LocalDate TestBirthday = LocalDate.of(2019, 8, 10);
		assertThat(TestName.isEqual(TestBirthday));		
		
	}
	
	
	@Test
	public void No29＿誕生日_全角アルファベット() throws Error {
		testsignupForm.setBirthday  = new TestName();
//		SimpleDateFormat df = new SimpleDateFormat("yyyy/MM/dd");
		LocalDate TestName = LocalDate.of(2019, 8, 10);
		LocalDate TestBirthday = LocalDate.of(2011, 8, 10);
		assertThat(TestName.isEqual(TestBirthday));		
		
	}
	
	
//No30半角かなはそもそもない
	
	
	
	@Test
	public void No31＿誕生日_半角ｶﾅ() throws java.lang.Error{
		testsignupForm.setBirthday  = new TestName();
//		SimpleDateFormat df = new SimpleDateFormat("yyyy/MM/dd");
		LocalDate TestName = LocalDate.of(2019, 8, 10);
		LocalDate TestBirthday = LocalDate.of(2011, 8, 10);
		assertThat(TestName.isEqual(TestBirthday));		
		
	}
	
	
	@Test
	public void No32＿誕生日_半角アルファベット() throws Error  {
		testsignupForm.setBirthday  = new TestName();
//		SimpleDateFormat df = new SimpleDateFormat("yyyy/MM/dd");
		LocalDate TestName = LocalDate.of(2019, 8, 10);
		LocalDate TestBirthday = LocalDate.of(2011, 8, 10);
		assertThat(TestName.isEqual(TestBirthday));		
		
	}
	
	
	@Test
	public void No33＿誕生日_全角数字() throws Error  {
		testsignupForm.setBirthday  = new TestName();
//		SimpleDateFormat df = new SimpleDateFormat("yyyy/MM/dd");
		LocalDate TestName = LocalDate.of(2019, 8, 10);
		LocalDate TestBirthday = LocalDate.of(２０３３, 8, 10);
		assertThat(TestName.isEqual(TestBirthday));		
		
	}
	
	
	@Test
	public void No34＿誕生日_全角記号() throws Error  {
		testsignupForm.setBirthday  = new TestName();
//		SimpleDateFormat df = new SimpleDateFormat("yyyy/MM/dd");
		LocalDate TestName = LocalDate.of(2019, 8, 10);
		LocalDate TestBirthday = LocalDate.of(2019,8,6);
		assertThat(TestName.isEqual(TestBirthday));		
		
	}
	
	
	@Test
	public void No35＿誕生日_全角かな() throws Error  {
		testsignupForm.setBirthday  = new TestName();
//		SimpleDateFormat df = new SimpleDateFormat("yyyy/MM/dd");
		LocalDate TestName = LocalDate.of(2019, 8, 10);
		LocalDate TestBirthday = LocalDate.of(2019, 8, 10);
		assertThat(TestName.isEqual(TestBirthday));		
		
	}
	
	
	@Test
	public void No36＿誕生日_全角カナ() throws Error  {
		testsignupForm.setBirthday  = new TestName();
//		SimpleDateFormat df = new SimpleDateFormat("yyyy/MM/dd");
		LocalDate TestName = LocalDate.of(2019, 8, 10);
		LocalDate TestBirthday = LocalDate.of(2019, 8, 10);
		assertThat(TestName.isEqual(TestBirthday));		
		
	}
	
	
	@Test
	public void No37＿誕生日_全角アルファベット() throws Error  {
		testsignupForm.setBirthday  = new TestName();
//		SimpleDateFormat df = new SimpleDateFormat("yyyy/MM/dd");
		LocalDate TestName = LocalDate.of(2019, 8, 10);
		LocalDate TestBirthday = LocalDate.of(20, 8, 10);
		assertThat(TestName.isEqual(TestBirthday));		
		
	}
	@Test
	public void No38＿年齢＿半角数字() {
		testsignupForm.setAge(20);
		assertThat(testsignupForm.getAge(), is(greaterThanOrEqualTo(20)));
	}
	
	@Test
	public void No39＿年齢＿全角数字() {
		testsignupForm.setAge(20);
		assertThat(testsignupForm.getAge(), is(greaterThanOrEqualTo(２０)));
	}
	
	
	@Test
	public void No40＿年齢＿21歳以上() {
		testsignupForm.setAge(21);
		assertThat(testsignupForm.getAge(), is(greaterThanOrEqualTo(20)));
	}
	
	
	@Test
	public void No41＿年齢＿20歳以上() {
		testsignupForm.setAge(20);
		assertThat(testsignupForm.getAge(), is(lessThanOrEqualTo(20)));
	}
	
	@Test
	public void No42＿年齢＿19歳以下() {
		testsignupForm.setAge(19);
		assertThat(testsignupForm.getAge(), is(lessThanOrEqualTo(20)));
	}
	
	@Test
	public void No43＿結婚＿未婚() {
		SignupForm testmarriage = new SignupForm();
		testmarriage.setMarriage(false);
		System.out.println(testmarriage);
		
		
//		assertTrue(testsignupForm.isMarriage(), is(lessThanOrEqualTo(20)));
	}
	
	@Test
	public void No44＿結婚＿既婚() {
		SignupForm testmarriage = new SignupForm();
		testmarriage.setMarriage(true);
		System.out.println(testmarriage);
		
		
	}
	
}
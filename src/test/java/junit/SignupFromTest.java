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

	private SignupForm testsignupForm  = new SignupForm();
	private BindingResult bindingResult = new BindException(testsignupForm , "UserForm");
	
	@Test(expected = NullPointerException.class)
	public void testExceptionThrown() {
	    String str = null;

	    str.contains("a");
	}
	
	
	@Test
    public void No1_ユーザID_メールアドレスチェック() {
		testsignupForm.setUserId("abc@gmail.com");
		assertThat(testsignupForm.getUserId(),allOf(match("^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9-]+(?:\\.[a-zA-Z0-9-]+)*$")));
    }
	  @Test
	    public void No2_ユーザID_全角アルファベット() {
		  testsignupForm.setUserId("ａbc@gmail.com");
		  assertThat(testsignupForm.getUserId(),allOf(match("^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9-]+(?:\\.[a-zA-Z0-9-]+)*$")));
	    }
	  
	  
	  @Test
	    public void No3_ユーザID_全角数字() {
		  testsignupForm.setUserId("１abc@gmail.com");
		  assertThat(testsignupForm.getUserId(),allOf(match("^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9-]+(?:\\.[a-zA-Z0-9-]+)*$")));
	    }
	  
	  
	  @Test
	    public void No4_ユーザID_全角記号() {
		  testsignupForm.setUserId("／abc@gmail.com");
		  assertThat(testsignupForm.getUserId(),allOf(match("^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9-]+(?:\\.[a-zA-Z0-9-]+)*$")));
	    }
	  
	  
	  @Test
	    public void No5_ユーザID_半角アルファベット() {
		  testsignupForm.setUserId("abc@gmail.com");
		  assertThat(testsignupForm.getUserId(),allOf(match("^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9-]+(?:\\.[a-zA-Z0-9-]+)*$")));
	    }
	 
	  
	  @Test
	    public void No6_ユーザID_半角数字() {
		  testsignupForm.setUserId("1abc@gmail.com");
		  assertThat(testsignupForm.getUserId(),allOf(match("^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9-]+(?:\\.[a-zA-Z0-9-]+)*$")));
	    }
	  
	  
	  @Test
	    public void No7_ユーザID_半角記号() {
		  testsignupForm.setUserId("/abc@gmail.com");
		  assertThat(testsignupForm.getUserId(),allOf(match("^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9-]+(?:\\.[a-zA-Z0-9-]+)*$")));
	    }
	  //No8半角かなは半角かな自体が存在しないためテストは飛ばします。
	  
	  
	  @Test
	    public void No9＿ユーザID_半角カナ() {
		  testsignupForm.setUserId("ｶﾅabc@gmail.com");
	      assertThat(testsignupForm.getUserId().contains("[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9-]+(?:\\.[a-zA-Z0-9-]+)*$"));
	      
	  }
	  
	  @Test
	    public void No10＿ユーザID_半角かな() {
		  testsignupForm.setUserId("かなabc@gmail.com");
	      assertThat(testsignupForm.getUserId().contains("[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9-]+(?:\\.[a-zA-Z0-9-]+)*$"));
	      
	  }
	  @Test
	    public void No11＿ユーザID_全角カナ() {
		  testsignupForm.setUserId("カナabc@gmail.com");
	      assertThat(testsignupForm.getUserId().contains("[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9-]+(?:\\.[a-zA-Z0-9-]+)*$"));

	  }
	  
	  @Test
	    public void No12＿ユーザID_漢字() {
		  testsignupForm.setUserId("仮名abc@gmail.com");
	      assertThat(testsignupForm.getUserId().contains("[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9-]+(?:\\.[a-zA-Z0-9-]+)*$"));

	  }
}	  


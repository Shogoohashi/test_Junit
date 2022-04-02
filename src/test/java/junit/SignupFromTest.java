package junit;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

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
		
	@Test
	
    public void No1_ユーザID_メールアドレスチェック() {
		testsignupForm.setUserId("abc@gmail.com");
        validator.validate(testsignupForm, bindingResult);
        assertEquals(bindingResult.getFieldError());
    }

	  
	  @Test
	    public void No2_ユーザID_全角アルファベット() {
		  testsignupForm.setUserId("ａbc@gmail.com");
		  validator.validate(testsignupForm, bindingResult);
		  assertNull(bindingResult.getFieldError());
	    }
	  
	  
	  @Test
	    public void No3_ユーザID_全角数字() {
		  testsignupForm.setUserId("１abc@gmail.com");
		  validator.validate(testsignupForm, bindingResult);
		  assertNull(bindingResult.getFieldError());
	    }
	  
	  
	  @Test
	    public void No4_ユーザID_全角記号() {
		  testsignupForm.setUserId("／abc@gmail.com");
		  validator.validate(testsignupForm, bindingResult);
		  assertNull(bindingResult.getFieldError());
	    }
	  
	  
	  @Test
	    public void No5_ユーザID_半角アルファベット() {
		  testsignupForm.setUserId("abc@gmail.com");
		  validator.validate(testsignupForm, bindingResult);
		  assertNull(bindingResult.getFieldError());
	    }
	 
	  
	  @Test
	    public void No6_ユーザID_半角数字() {
		  testsignupForm.setUserId("1abc@gmail.com");
		  validator.validate(testsignupForm, bindingResult);
		  assertNull(bindingResult.getFieldError());
	    }
	  
	  
	  @Test
	    public void No7_ユーザID_半角記号() {
		  testsignupForm.setUserId("/abc@gmail.com");
		  validator.validate(testsignupForm, bindingResult);
		  assertNull(bindingResult.getFieldError());
	    }
	  
	  
	  
}


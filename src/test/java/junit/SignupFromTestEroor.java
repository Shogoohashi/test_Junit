package junit;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;

import com.example.demo.login.domain.model.SignupForm;
import com.example.demo.login.domain.model.User;

public class SignupFromTestEroor {
	
	

	@Autowired
	Validator validator;
	
	private SignupForm testsignupForm = new SignupForm();
	private BindingResult bindingResult = new BindException(testsignupForm, "test");

    @Before
    public void before() {
		testsignupForm.setUserId("aaaaaaa");
		testsignupForm.setPassword("sannma");
        testsignupForm.setUserName("oohasi");
    }
	
//    @Rule
//    public ExpectedException thrown = ExpectedException.none();
	//
	//異常系テスト
	//
	@Test(expected = NullPointerException.class)
	 public void No1_異常系_ユーザID() {
		 testsignupForm.setUserId(null);
		 validator.validate(testsignupForm, bindingResult);
		 assertThat(bindingResult.getFieldError().getField(),is("userId"));
		 assertThat(bindingResult.getFieldError().getDefaultMessage(),is("メールアドレスではありません"));
	 }
	
	@Test(expected = NullPointerException.class)
    public void No2＿異常系＿上限値21以上() {
		testsignupForm.setPassword(null);
		assertThat(testsignupForm.getPassword().matches("^[0-9a-z.?/-]{8,20}"));
	}
	
	@Test(expected = NullPointerException.class)
    public void No3＿異常系＿下限値7文字以下() {
		testsignupForm.setPassword(null);
		assertThat(testsignupForm.getPassword().matches("^[0-9a-z.?/-]{8,20}"));
	}
	
	@Test(expected = NullPointerException.class)
    public void No４＿異常系＿未入力() {
		testsignupForm.setPassword(null);
		assertThat(testsignupForm.getPassword().equals("^[0-9a-z.?/-]{8,20}"));
	}
        
//        validator.validate(testsignupForm, bindingResult);
//        assertThat(bindingResult.getFieldError().toString()).contains("8文字以上でパスワード登録ができます");
    
}
//}

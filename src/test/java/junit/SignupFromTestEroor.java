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
}
//	
//	@Test
//    public void No2＿異常系＿パスワード() {
//        testsignupForm.setPassword("aaaa");
//        validator.validate(testsignupForm, bindingResult);
//        assertThat(bindingResult.getFieldError().toString()).contains("8文字以上でパスワード登録ができます");
//    }
//}

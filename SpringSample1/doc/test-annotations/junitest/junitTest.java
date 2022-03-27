package junitest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;

import com.example.demo.login.domain.model.SignupForm;

public class junitTest {

	@Autowired
	Validator validator;

	private SignupForm testsignupForm = new SignupForm();
	private BindingResult bindingResult = new BindException(testsignupForm, "signupForm");

	
	//正常　userId
	@Test
	public void メールアドレス形式_小文字英数字() {
		// テスト準備
		testsignupForm.setUserId("aaaa@aaaaa");
		// テスト実施
		validator.validate(testsignupForm, bindingResult);
		// 結果検証
		assertNull(bindingResult.getFieldError());

	}

	public void メールアドレス形式＿大文字英数字() {
		// テスト準備
		testsignupForm.setUserId("AAAA@aaaa");
		// テスト実施
		validator.validate(testsignupForm, bindingResult);
		// 結果検証
		assertNull(bindingResult.getFieldError());
	}
	
	public void メールアドレス形式_大文字小文字英数字() {
		// テスト準備
		testsignupForm.setUserId("AAaa@aaaa");
		// テスト実施
		validator.validate(testsignupForm, bindingResult);
		// 結果検証
		assertNull(bindingResult.getFieldError());
	}
	
    public void 異常系_カタカナ() {
        // テスト準備
    	testsignupForm.setUserId("アアアア");
        // テスト実施
        validator.validate(testsignupForm, bindingResult);
        // 結果検証
        assertThat(bindingResult.getFieldError().toString()).contains("半角全角英数のみ有効です。");
    }
    
    public void 異常系_ひらがな() {
        // テスト準備
    	testsignupForm.setUserId("ああああ");
        // テスト実施
        validator.validate(testsignupForm, bindingResult);
        // 結果検証
        assertThat(bindingResult.getFieldError().toString()).contains("半角全角英数のみ有効です。");
    }
	
    public void 異常系_漢字() {
        // テスト準備
    	testsignupForm.setUserId("嗚呼嗚呼");
        // テスト実施
        validator.validate(testsignupForm, bindingResult);
        // 結果検証
        assertThat(bindingResult.getFieldError().toString()).contains("半角全角英数のみ有効です。");
    }
}

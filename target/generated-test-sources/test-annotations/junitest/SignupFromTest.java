package junitest;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.Validator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.core.Is.is;
import org.hamcrest.Matcher;

import static org.junit.Assert.*;

import com.example.demo.login.domain.model.SignupForm;

public class SignupFromTest {

	@Autowired
	Validator validator;

	private SignupForm userForm = new SignupForm();
	private BindingResult bindingResult = new BindException(userForm, "UserForm");

	
	//正常　userId      ß
	@Test
	public void ユーザーID＿正常系＿１＿半角アルファベット() {
		userForm.setUserId("aaaaaaa");
		validator.validate(userForm,bindingResult);
					//期待値（計算過程)　　　　　　　　　実測値（答え）　　　　　　　　　　　　　　　
		assertThat(bindingResult, is("aaaa"));
	}
	@Test
	public void ユーザーID＿正常系_３＿半角記号() {
		// テスト準備
		userForm.setUserId("//////");
		// テスト実施
		validator.validate(userForm, bindingResult);
		// 結果検証
		assertNull(bindingResult.getFieldError());
	}
	@Test
	public void ユーザーID＿正常＿２＿半角数字() {
		// int型でできるようにしたい
		userForm.setUserId("1111");
		// テスト実施
		validator.validate(userForm, bindingResult);
		// 結果検証
		assertNull(bindingResult.getFieldError());
	}
	
	@Test
	public void ユーザーID＿正常＿４＿全角アルファベット() {
		// int型でできるようにしたい
		userForm.setUserId("ａａａａａａａ");
		// テスト実施
		validator.validate(userForm, bindingResult);
		// 結果検証
		assertNull(bindingResult.getFieldError());
	}
	
	//ユーザID　異常系
	
	@Test
    public void ユーザーID＿異常系＿１_カタカナ() {
        // テスト準備
    	userForm.setUserId("アアアア");
        // テスト実施
        validator.validate(userForm, bindingResult);
        // 結果検証
        assertThat(bindingResult.getFieldError().toString()).contains("半角全角英数のみ有効です。");
    }
	@Test
    public void ユーザーID＿異常系_２＿ひらがな() {
        // テスト準備
    	userForm.setUserId("ああああ");
        // テスト実施
        validator.validate(userForm, bindingResult);
        // 結果検証
        assertThat(bindingResult.getFieldError().toString()).contains("半角全角英数のみ有効です。");
    }
	@Test
    public void ユーザーID＿異常系＿３_漢字() {
        // テスト準備
    	userForm.setUserId("嗚呼嗚呼");
        // テスト実施
        validator.validate(userForm, bindingResult);
        // 結果検証
        assertThat(bindingResult.getFieldError().toString()).contains("半角全角英数のみ有効です。");
    }
	@Test
    public void ユーザーID＿異常系＿４_半角ｶﾅ() {
        // テスト準備
    	userForm.setUserId("ｱｱｱｱ");
        // テスト実施
        validator.validate(userForm, bindingResult);
        // 結果検証
        assertThat(bindingResult.getFieldError().toString()).contains("半角全角英数のみ有効です。");
    }
    
   
}

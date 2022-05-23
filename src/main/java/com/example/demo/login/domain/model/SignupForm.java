package com.example.demo.login.domain.model;

import java.util.Date;

import javax.validation.constraints.AssertFalse;
import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.ScriptAssert;
import org.junit.rules.TestName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.validation.Validator;

import lombok.Data;

 @Data
public class SignupForm {
	@Autowired
    //必須入力、メールアドレス形式
    @NotBlank(groups = ValidGroup1.class, message = "{require_check}")
    @Email(groups = ValidGroup1.class, message = "{email_check}")
	@Pattern(regexp = "[a-zA-Z0-9]*")
    private String userId;// ユーザーID
	
    //必須入力、長さ4から100桁まで、半角英数字のみ
    @NotBlank(groups = ValidGroup1.class, message = "{require_check}")
    @Length(min = 8,max = 20,groups = ValidGroup1.class, message = "{length_check}")
    @Size(min = 8,max = 20,groups = ValidGroup1.class,message = "{size_check}")
    @Pattern(regexp = "^[a-z0-9]+$", groups = ValidGroup1.class, message = "{pattern_check}")    
	public String password; // パスワード

    //必須入力
    @NotBlank(groups = ValidGroup1.class, message = "{require_check}")
    private String userName; // ユーザー名

    //必須入力
    @NotNull(groups = ValidGroup1.class, message = "{require_check}")
    @DateTimeFormat(pattern = "yyyy/MM/dd")
    private Date birthday; // 誕生日

    //値が20から100まで
    @Min(value = 20, groups = ValidGroup1.class, message = "{min_check}")
    @Max(value = 100, groups = ValidGroup1.class, message = "{max_check}")
    private int age; // 年齢

    //falseのみ可能
    @AssertFalse(groups = ValidGroup1.class, message = "{false_check}")
    private boolean marriage; // 結婚ステータス

	public TestName setBirthday;
    
    public String getPassword() {
    	return password;
    	
    }
    public void setPassword(String password) {
       this.password = password;
    }

    
}

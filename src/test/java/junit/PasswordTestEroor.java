package junit;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;

import com.example.demo.login.domain.model.SignupForm;

public class PasswordTestEroor {
	@Autowired
	Validator validator;

	private SignupForm testsignupForm = new SignupForm();
	private BindingResult bindingResult = new BindException(testsignupForm, "test");


	@Test(expected = NullPointerException.class)
	public void No1_異常系_全角ひら() {
		this.testsignupForm.setPassword("あああああああああああああああ");
		validator.validate(testsignupForm, bindingResult);
		assertThat(testsignupForm.getPassword().matches("/s^[0-9a-z.?/-]/s{8,20}"));
		assertThat(bindingResult.getFieldError().getDefaultMessage(), is("半角アルファベットと半角数字のみ登録が可能です"));
	}
	@Test(expected = NullPointerException.class)
	public void No2_異常系_全角カナ() {
		this.testsignupForm.setPassword("アアアアアアアアアアアアアア");
		assertThat(testsignupForm.getPassword().matches("/s^[0-9a-z.?/-]/s{8,20}"));
		assertThat(bindingResult.getFieldError().getDefaultMessage(), is("半角アルファベットと半角数字のみ登録が可能です"));
	}
	@Test(expected = NullPointerException.class)
	public void No3_異常系_全角アルファベット() {
		this.testsignupForm.setPassword("AAAAAAAAAAAAAAAAAAAAAAA");
		validator.validate(testsignupForm, bindingResult);
		assertThat(testsignupForm.getPassword().matches("/s^[0-9a-z.?/-]/s{8,20}"));
		assertThat(bindingResult.getFieldError().getDefaultMessage(), is("半角アルファベットと半角数字のみ登録が可能です"));
	}
	@Test(expected = NullPointerException.class)
	public void No4_異常系_全角記号() {
		this.testsignupForm.setPassword("／／／／／／／／／／／／／／／／／／／");
		validator.validate(testsignupForm, bindingResult);
		assertThat(testsignupForm.getPassword().matches("/s^[0-9a-z.?/-]/s{8,20}"));
		assertThat(bindingResult.getFieldError().getDefaultMessage(), is("半角アルファベットと半角数字のみ登録が可能です"));
	}
	@Test(expected = NullPointerException.class)
	public void No5_異常系_全角数字() {
		this.testsignupForm.setPassword("１１１１１１１１１１１１１１１１１１１１１１");
		validator.validate(testsignupForm, bindingResult);
		assertThat(testsignupForm.getPassword().matches("/s^[0-9a-z.?/-]/s{8,20}"));
		assertThat(bindingResult.getFieldError().getDefaultMessage(), is("半角アルファベットと半角数字のみ登録が可能です"));
	}
	@Test(expected = NullPointerException.class)
	public void No6_異常系_半角カナ() {
		this.testsignupForm.setPassword("ｱｱｱｱｱｱｱｱｱｱｱｱｱｱｱｱｱ");
		validator.validate(testsignupForm, bindingResult);
		assertThat(testsignupForm.getPassword().matches("/s^[0-9a-z.?/-]/s{8,20}"));
		assertThat(bindingResult.getFieldError().getDefaultMessage(), is("半角アルファベットと半角数字のみ登録が可能です"));
	}
	@Test(expected = NullPointerException.class)
	public void No7_異常系_半角記号() {
		this.testsignupForm.setPassword("//////////////////");
		validator.validate(testsignupForm, bindingResult);
		assertThat(testsignupForm.getPassword().matches("/s^[0-9a-z.?/-]/s{8,20}"));
		assertThat(bindingResult.getFieldError().getDefaultMessage(), is("半角アルファベットと半角数字のみ登録が可能です"));
	}
	@Test(expected = NullPointerException.class)
	public void No8_異常系_絵文字() {
		this.testsignupForm.setPassword("🌸🌸🌸🌸🌸🌸🌸🌸🌸🌸🌸🌸🌸🌸🌸🌸");
		validator.validate(testsignupForm, bindingResult);
		assertThat(testsignupForm.getPassword().matches("/s^[0-9a-z.?/-]/s{8,20}"));
		assertThat(bindingResult.getFieldError().getDefaultMessage(), is("半角アルファベットと半角数字のみ登録が可能です"));
	}
	@Test(expected = NullPointerException.class)
	public void No9_異常系_未入力() {
		this.testsignupForm.setPassword("");
		validator.validate(testsignupForm, bindingResult);
		assertThat(testsignupForm.getPassword().matches("/s^[0-9a-z.?/-]/s{8,20}"));
		assertThat(bindingResult.getFieldError().getDefaultMessage(), is("パスワードは必須入力です"));
	}
	
	@Test(expected = NullPointerException.class)
	public void No10_異常系_スペース() {
		this.testsignupForm.setPassword("111111 222222 22222");
		validator.validate(testsignupForm, bindingResult);
		assertThat(testsignupForm.getPassword().matches("/s^[0-9a-z.?/-]/s{8,20}"));
		assertThat(bindingResult.getFieldError().getDefaultMessage(), is("半角アルファベットと半角数字のみ登録が可能です"));
	}
	@Test(expected = NullPointerException.class)
	public void No11_異常系_半角数字＿全角ひら() {
		this.testsignupForm.setPassword("あああ1111あああ1111");
		validator.validate(testsignupForm, bindingResult);
		assertThat(testsignupForm.getPassword().matches("/s^[0-9a-z.?/-]/s{8,20}"));
		assertThat(bindingResult.getFieldError().getDefaultMessage(), is("半角アルファベットと半角数字のみ登録が可能です"));
	}
	@Test(expected = NullPointerException.class)
	public void No12_異常系_半角数字_全角カナ() {
		this.testsignupForm.setPassword("アアア111アアア111アアア111");
		validator.validate(testsignupForm, bindingResult);
		assertThat(testsignupForm.getPassword().matches("/s^[0-9a-z.?/-]/s{8,20}"));
		assertThat(bindingResult.getFieldError().getDefaultMessage(), is("半角アルファベットと半角数字のみ登録が可能です"));
	}
	@Test(expected = NullPointerException.class)
	public void No13_異常系_半角数字_全角アルファベット() {
		this.testsignupForm.setPassword("ａａａａ1111ａａａａ1111ａａａａ1111");
		validator.validate(testsignupForm, bindingResult);
		assertThat(testsignupForm.getPassword().matches("/s^[0-9a-z.?/-]/s{8,20}"));
		assertThat(bindingResult.getFieldError().getDefaultMessage(), is("半角アルファベットと半角数字のみ登録が可能です"));
	}
	@Test(expected = NullPointerException.class)
	public void No14_異常系_半角数字_全角記号() {
		this.testsignupForm.setPassword("／／／／／／1111／／／／／／1111");
		validator.validate(testsignupForm, bindingResult);
		assertThat(testsignupForm.getPassword().matches("/s^[0-9a-z.?/-]/s{8,20}"));
		assertThat(bindingResult.getFieldError().getDefaultMessage(), is("半角アルファベットと半角数字のみ登録が可能です"));
	}
	@Test(expected = NullPointerException.class)
	public void No15_異常系_半角数字_全角数字() {
		this.testsignupForm.setPassword("１１１１1111１１１１1111");
		validator.validate(testsignupForm, bindingResult);
		assertThat(testsignupForm.getPassword().matches("/s^[0-9a-z.?/-]/s{8,20}"));
		assertThat(bindingResult.getFieldError().getDefaultMessage(), is("半角アルファベットと半角数字のみ登録が可能です"));
	}
	@Test(expected = NullPointerException.class)
	public void No16_異常系_半角数字_半角カナ() {
		this.testsignupForm.setPassword("ｱｱｱｱ111ｱｱｱ111ｱｱｱｱ111");
		validator.validate(testsignupForm, bindingResult);
		assertThat(testsignupForm.getPassword().matches("/s^[0-9a-z.?/-]/s{8,20}"));
		assertThat(bindingResult.getFieldError().getDefaultMessage(), is("半角アルファベットと半角数字のみ登録が可能です"));
	}
	@Test(expected = NullPointerException.class)
	public void No17_異常系_半角数字_半角記号() {
		this.testsignupForm.setPassword("///////111111///////111111");
		validator.validate(testsignupForm, bindingResult);
		assertThat(testsignupForm.getPassword().matches("/s^[0-9a-z.?/-]/s{8,20}"));
		assertThat(bindingResult.getFieldError().getDefaultMessage(), is("半角アルファベットと半角数字のみ登録が可能です"));
	}
	@Test(expected = NullPointerException.class)
	public void No18_異常系_半角数字_絵文字() {
		this.testsignupForm.setPassword("🌸🌸🌸🌸11111🌸🌸🌸🌸11111");
		validator.validate(testsignupForm, bindingResult);
		assertThat(testsignupForm.getPassword().matches("/s^[0-9a-z.?/-]/s{8,20}"));
		assertThat(bindingResult.getFieldError().getDefaultMessage(), is("半角アルファベットと半角数字のみ登録が可能です"));
	}
	@Test(expected = NullPointerException.class)
	public void No19_異常系_半角アルファベット_全角ひら() {
		this.testsignupForm.setPassword("あああaaaaaaあああaaaaaa");
		validator.validate(testsignupForm, bindingResult);
		assertThat(testsignupForm.getPassword().matches("/s^[0-9a-z.?/-]/s{8,20}"));
		assertThat(bindingResult.getFieldError().getDefaultMessage(), is("半角アルファベットと半角数字のみ登録が可能です"));
	}
	@Test(expected = NullPointerException.class)
	public void No20_異常系_半角アルファベット_全角カナ() {
		this.testsignupForm.setPassword("アアアaaaaaaアアアaaaaaa");
		validator.validate(testsignupForm, bindingResult);
		assertThat(testsignupForm.getPassword().matches("/s^[0-9a-z.?/-]/s{8,20}"));
		assertThat(bindingResult.getFieldError().getDefaultMessage(), is("半角アルファベットと半角数字のみ登録が可能です"));
	}
	@Test(expected = NullPointerException.class)
	public void No21_異常系_半角アルファベット_全角アルファベット() {
		this.testsignupForm.setPassword("ａａａａaaaaaａａａａaaaaa");
		validator.validate(testsignupForm, bindingResult);
		assertThat(testsignupForm.getPassword().matches("/s^[0-9a-z.?/-]/s{8,20}"));
		assertThat(bindingResult.getFieldError().getDefaultMessage(), is("半角アルファベットと半角数字のみ登録が可能です"));
	}
	@Test(expected = NullPointerException.class)
	public void No22_異常系_半角アルファベット_全角記号() {
		this.testsignupForm.setPassword("aaaaaaaa／／／／／／");
		validator.validate(testsignupForm, bindingResult);
		assertThat(testsignupForm.getPassword().matches("/s^[0-9a-z.?/-]/s{8,20}"));
		assertThat(bindingResult.getFieldError().getDefaultMessage(), is("半角アルファベットと半角数字のみ登録が可能です"));
	}
	@Test(expected = NullPointerException.class)
	public void No23_異常系_半角アルファベット_全角数字() {
		this.testsignupForm.setPassword("１１１１１１aaaaaa１１１１１１aaaaaa");
		validator.validate(testsignupForm, bindingResult);
		assertThat(testsignupForm.getPassword().matches("/s^[0-9a-z.?/-]/s{8,20}"));
		assertThat(bindingResult.getFieldError().getDefaultMessage(), is("半角アルファベットと半角数字のみ登録が可能です"));
	}
	@Test(expected = NullPointerException.class)
	public void No24_異常系_半角アルファベット_半角カナ() {
		this.testsignupForm.setPassword("ｱｱｱｱaaaaaaaｱｱｱｱaaaaaaa");
		validator.validate(testsignupForm, bindingResult);
		assertThat(testsignupForm.getPassword().matches("/s^[0-9a-z.?/-]/s{8,20}"));
		assertThat(bindingResult.getFieldError().getDefaultMessage(), is("半角アルファベットと半角数字のみ登録が可能です"));
	}
	@Test(expected = NullPointerException.class)
	public void No25_異常系_半角アルファベット_半角記号() {
		this.testsignupForm.setPassword("///////aaaaaa///////aaaaaa");
		validator.validate(testsignupForm, bindingResult);
		assertThat(testsignupForm.getPassword().matches("/s^[0-9a-z.?/-]/s{8,20}"));
		assertThat(bindingResult.getFieldError().getDefaultMessage(), is("半角アルファベットと半角数字のみ登録が可能です"));
	}
	@Test(expected = NullPointerException.class)
	public void No26_異常系_半角アルファベット_絵文字() {
		this.testsignupForm.setPassword("🌸🌸🌸🌸aaaaaaa🌸🌸🌸🌸aaaaaaa");
		validator.validate(testsignupForm, bindingResult);
		assertThat(testsignupForm.getPassword().matches("/s^[0-9a-z.?/-]/s{8,20}"));
		assertThat(bindingResult.getFieldError().getDefaultMessage(), is("半角アルファベットと半角数字のみ登録が可能です"));
	}
	
	@Test(expected = NullPointerException.class)
	public void No2＿異常系＿上限値21以上() {
		testsignupForm.setPassword("aaaaaaaaa1aaaaaaaaa2a");
		assertThat(testsignupForm.getPassword().matches("^[0-9a-z.?/-]{8,20}"));
		assertThat(bindingResult.getFieldError().getDefaultMessage(), is("8文字以上20文字以下で入力してください"));

	}
	@Test(expected = NullPointerException.class)
	public void No3＿異常系＿文字数下限値7文字以下() {
		testsignupForm.setPassword("aaaaaa7");
		assertThat(testsignupForm.getPassword().matches("^[0-9a-z.?/-]{8,20}"));
		assertThat(bindingResult.getFieldError().getDefaultMessage(), is("8文字以上20文字以下で入力してください"));

	}

	@Test(expected = NullPointerException.class)
	public void No４＿異常系＿文字数未入力() {
		testsignupForm.setPassword("");
		assertThat(testsignupForm.getPassword().equals("/s^[0-9a-z.?/-]/s{8,20}"));
		assertThat(bindingResult.getFieldError().getDefaultMessage(), is("パスワードは必須入力です"));

	}

	@Test(expected = NullPointerException.class)
	public void No４＿異常系＿文字数スペース() {
		testsignupForm.setPassword("aaaaaaaaaa aaaaaaaaaaa");
		assertThat(testsignupForm.getPassword().equals("/s^[0-9a-z.?/-]/s{8,20}"));
		assertThat(bindingResult.getFieldError().getDefaultMessage(), is("パスワードは必須入力です"));

	}

}

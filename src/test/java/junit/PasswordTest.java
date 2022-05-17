package junit;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;

import javax.validation.Validation;
import javax.validation.ValidatorFactory;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;

import com.example.demo.login.domain.model.SignupForm;
import com.example.demo.login.domain.model.ValidGroup1;

public class PasswordTest {
	
	private SignupForm SignupForm = new SignupForm();

	private BindingResult bindingResult = new BindException(SignupForm, "echoForm");
	   @Autowired
	   private static Validator validator;
	
	@Test
	public void No1＿パスワード_半角数字() {
		this.SignupForm.setPassword("111111111111111111111");
		assertThat(SignupForm.getPassword().matches("/s^[0-9a-z.?/-]/s{8,20}"));
    }
	
	@Test
	public void No2＿パスワード_半角アルファベット() {
		this.SignupForm.setPassword("aaaaaaaaaaaaa");
		assertThat(SignupForm.getPassword().matches("/s^[0-9a-z.?/-]/s{8,20}"));
    }
	
	@Test
	public void No3＿パスワード_全角ひら() {
		this.SignupForm.setPassword("あああああああああああああああ");
		assertThat(SignupForm.getPassword().matches("/s^[0-9a-z.?/-]/s{8,20}"));
    }
	
	@Test
	public void No4＿パスワード_全角カナ() {
		this.SignupForm.setPassword("アアアアアアアアアアアアア");
		assertThat(SignupForm.getPassword().matches("/s^[0-9a-z.?/-]/s{8,20}"));
    }
	
	@Test
	public void No5＿パスワード_全角アルファベット() {
		this.SignupForm.setPassword("AAAAAAAAAAA");
		assertThat(SignupForm.getPassword().matches("/s^[0-9a-z.?/-]/s{8,20}"));
    }
	
	@Test
	public void No6＿パスワード_全角記号() {
		this.SignupForm.setPassword("／／／／／／／／／／／／／／／／／／");
		assertThat(SignupForm.getPassword().matches("/s^[0-9a-z.?/-]/s{8,20}"));
    }
	
	@Test
	public void No7＿パスワード_全角数字() {
		this.SignupForm.setPassword("１１１１１１１１１１１１１１１１１１１");
		assertThat(SignupForm.getPassword().matches("/s^[0-9a-z.?/-]/s{8,20}"));
    }
	
	@Test
	public void No8＿パスワード_半角カナ() {
		this.SignupForm.setPassword("ｱｱｱｱｱｱ");
		assertThat(SignupForm.getPassword().matches("/s^[0-9a-z.?/-]/s{8,20}"));
    }
	
	@Test
	public void No9＿パスワード_半角記号() {
		this.SignupForm.setPassword("////////////////////");
		assertThat(SignupForm.getPassword().matches("/s^[0-9a-z.?/-]/s{8,20}"));
    }
	
	@Test
	public void No10＿パスワード_絵文字() {
		this.SignupForm.setPassword("🌸🌸🌸🌸");
		assertThat(SignupForm.getPassword().matches("/s^[0-9a-z.?/-]/s{8,20}"));
    }
	@Test
	public void No11＿パスワード_半角数字＿全角ひら() {
		this.SignupForm.setPassword("あああ1111");
		assertThat(SignupForm.getPassword().matches("/s^[0-9a-z.?/-]/s{8,20}"));
    }
	
	@Test
	public void No12＿パスワード_半角数字_全角カナ() {
		this.SignupForm.setPassword("アアア111");
		assertThat(SignupForm.getPassword().matches("/s^[0-9a-z.?/-]/s{8,20}"));
    }
	@Test
	public void No13＿パスワード_半角数字_全角アルファベット() {
		this.SignupForm.setPassword("ａａａａ1111");
		assertThat(SignupForm.getPassword().matches("/s^[0-9a-z.?/-]/s{8,20}"));
    }
	@Test
	public void No14＿パスワード_半角数字_全角記号() {
		this.SignupForm.setPassword("／／／／／／1111");
		assertThat(SignupForm.getPassword().matches("/s^[0-9a-z.?/-]/s{8,20}"));
    }
	@Test
	public void No15＿パスワード_半角数字_全角数字() {
		this.SignupForm.setPassword("1111111１１１１１１");
		assertThat(SignupForm.getPassword().matches("/s^[0-9a-z.?/-]/s{8,20}"));
    }
	@Test
	public void No16＿パスワード_半角数字_半角カナ() {
		this.SignupForm.setPassword("ｱｱｱｱ11111");
		assertThat(SignupForm.getPassword().matches("/s^[0-9a-z.?/-]/s{8,20}"));
    }
	@Test
	public void No17＿パスワード_半角数字_半角記号() {
		this.SignupForm.setPassword("///////111111");
		assertThat(SignupForm.getPassword().matches("/s^[0-9a-z.?/-]/s{8,20}"));
    }
	@Test
	public void No18＿パスワード_半角数字_絵文字() {
		this.SignupForm.setPassword("🌸🌸🌸🌸11111");
		assertThat(SignupForm.getPassword().matches("/s^[0-9a-z.?/-]/s{8,20}"));
    }
	
	
	
	@Test
	public void No19＿パスワード_半角アルファベット_全角ひら() {
		this.SignupForm.setPassword("あああaaaaaa");
		assertThat(SignupForm.getPassword().matches("/s^[0-9a-z.?/-]/s{8,20}"));
    }
	@Test
	public void No20＿パスワード_半角アルファベット_全角カナ(){
		this.SignupForm.setPassword("アアアaaaaaa");
		assertThat(SignupForm.getPassword().matches("/s^[0-9a-z.?/-]/s{8,20}"));
    }
	@Test
	public void No21＿パスワード_半角アルファベット_全角アルファベット() {
		this.SignupForm.setPassword("ａａａａａａａaaaaa");
		assertThat(SignupForm.getPassword().matches("/s^[0-9a-z.?/-]/s{8,20}"));
    }
	@Test
	public void No22＿パスワード_半角アルファベット_全角記号() {
		this.SignupForm.setPassword("／／／aaaaaa");
		assertThat(SignupForm.getPassword().matches("/s^[0-9a-z.?/-]/s{8,20}"));
    }
	@Test
	public void No23＿パスワード_半角アルファベット_全角数字() {
		this.SignupForm.setPassword("１１１１aaaaaa");
		assertThat(SignupForm.getPassword().matches("/s^[0-9a-z.?/-]/s{8,20}"));
    }
	@Test
	public void No24＿パスワード_半角アルファベット_半角カナ() {
		this.SignupForm.setPassword("ｱｱｱｱaaaaaaa");
		assertThat(SignupForm.getPassword().matches("/s^[0-9a-z.?/-]/s{8,20}"));
    }
	@Test
	public void No25＿パスワード_半角アルファベット_半角記号() {
		this.SignupForm.setPassword("///////aaaaaa");
		assertThat(SignupForm.getPassword().matches("/s^[0-9a-z.?/-]/s{8,20}"));
    }
	@Test
	public void No26＿パスワード_半角アルファベット_絵文字() {
		this.SignupForm.setPassword("🌸🌸🌸🌸aaaaaaa");
		assertThat(SignupForm.getPassword().matches("/s^[0-9a-z.?/-]/s{8,20}"));
    }
	@Test
	public void No27＿パスワード_半角数字_半角アルファベット() {
		this.SignupForm.setPassword("1111aaaaaa");
		assertThat(SignupForm.getPassword().matches("/s^[0-9a-z.?/-]/s{8,20}"));
    }
	@Test
	public void No28＿パスワード_文字数21字() {
		this.SignupForm.setPassword("aaaaaaaaa1aaaaaaaaa2a");
		assertThat(SignupForm.getPassword().matches("/s^[0-9a-z.?/-]/s{8,20}"));
    }
	@Test
	public void No29＿パスワード_文字数20字() {
		this.SignupForm.setPassword("aaaaaaaaa1aaaaaaaaa2");
		assertThat(SignupForm.getPassword().matches("/s^[0-9a-z.?/-]/s{8,20}"));
    }
	@Test
	public void No30＿パスワード_文字数19字() {
		this.SignupForm.setPassword("aaaaaaaaa1aaaaaaaaa");
		assertThat(SignupForm.getPassword().matches("/s^[0-9a-z.?/-]/s{8,20}"));
    }

	@Test
	public void No31＿パスワード_文字数９字() {
		this.SignupForm.setPassword("aaaaaaaa9");
		assertThat(SignupForm.getPassword().matches("/s^[0-9a-z.?/-]/s{8,20}"));
    }
	@Test
	public void No32＿パスワード_文字数8字() {
		this.SignupForm.setPassword("aaaaaaa8");
		assertThat(SignupForm.getPassword().matches("/s^[0-9a-z.?/-]/s{8,20}"));
    }
	@Test
	public void No33＿パスワード_文字数7字() {
		this.SignupForm.setPassword("aaaaaa7");
		assertThat(SignupForm.getPassword().matches("/s^[0-9a-z.?/-]/s{8,20}"));
    }
	
	
}
package junit;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.*;
import static org.junit.Assert.assertThat;
import static org.mockito.ArgumentMatchers.*;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Length;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.lang.annotation.Annotation;

import com.example.demo.login.domain.model.SignupForm;
import com.example.demo.login.domain.model.ValidGroup1;

@SpringBootTest
public class PasswordTest {

	@Autowired
	private Validator validator;
	private SignupForm signupForm;
	private static final String OK = "1111111111aaaaaaaaaa";

	@Before
	public void setUp() {
		signupForm = new SignupForm();
		// validateメソッドを使った入力チェックを可能にするためにValidatorを取得する。
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		validator = factory.getValidator();

	}

	@Test
	public void No1＿パスワード_半角数字() {
		signupForm.setPassword("11111111111111111");
		Set<ConstraintViolation<SignupForm>> violations = validator.validate(signupForm);
		// validateメソッドを使い入力チェックを行う。
		assertTrue(signupForm.getPassword().matches(("[a-z0-9]{8,20}")));
	}

	@Test
	public void No2＿パスワード_半角アルファベット() {
		signupForm.password = "aaaaaaaaaaaaaaaaaaaa";
		Set<ConstraintViolation<SignupForm>> violations = validator.validate(signupForm);
		// validateメソッドを使い入力チェックを行う。
		assertTrue(signupForm.getPassword().matches(("[a-z0-9]{8,20}")));

	}

	@Test
	public void No3＿パスワード_全角ひら() {
		signupForm.password = "あああああああああああああああああああ";
		Set<ConstraintViolation<SignupForm>> violations = validator.validate(signupForm);
		// validateメソッドを使い入力チェックを行う。
		assertFalse(signupForm.getPassword().matches(("[a-z0-9]{8,20}")));

	}

	@Test
	public void No4＿パスワード_全角カナ() {
		signupForm.password = "アアアアアアアアアアアアア";
		Set<ConstraintViolation<SignupForm>> violations = validator.validate(signupForm);
		// validateメソッドを使い入力チェックを行う。
		assertFalse(signupForm.getPassword().matches(("[a-z0-9]{8,20}")));

	}

	@Test
	public void No5＿パスワード_全角アルファベット() {
		signupForm.password = "AAAAAAAAAAA";
		Set<ConstraintViolation<SignupForm>> violations = validator.validate(signupForm);
		// validateメソッドを使い入力チェックを行う。
		assertFalse(signupForm.getPassword().matches(("[a-z0-9]{8,20}")));
	}

	@Test
	public void No6＿パスワード_全角記号() {
		signupForm.password = "／／／／／／／／／／／／／／／／／／";
		Set<ConstraintViolation<SignupForm>> violations = validator.validate(signupForm);
		// validateメソッドを使い入力チェックを行う。
		assertFalse(signupForm.getPassword().matches(("[a-z0-9]{8,20}")));
	}

	@Test
	public void No7＿パスワード_全角数字() {
		signupForm.password = "１１１１１１１１１１１１１１１１１１１";
		Set<ConstraintViolation<SignupForm>> violations = validator.validate(signupForm);
		// validateメソッドを使い入力チェックを行う。
		assertFalse(signupForm.getPassword().matches(("[a-z0-9]{8,20}")));
	}

	@Test
	public void No8＿パスワード_半角カナ() {
		signupForm.password = "ｱｱｱｱｱｱ";
		Set<ConstraintViolation<SignupForm>> violations = validator.validate(signupForm);
		// validateメソッドを使い入力チェックを行う。
		assertFalse(signupForm.getPassword().matches(("[a-z0-9]{8,20}")));
	}

	@Test
	public void No9＿パスワード_半角記号() {
		signupForm.password = "////////////////////";
		Set<ConstraintViolation<SignupForm>> violations = validator.validate(signupForm);
		// validateメソッドを使い入力チェックを行う。
		assertFalse(signupForm.getPassword().matches(("[a-z0-9]{8,20}")));
	}

	@Test
	public void No10＿パスワード_絵文字() {
		signupForm.password = "🌸🌸🌸🌸";
		Set<ConstraintViolation<SignupForm>> violations = validator.validate(signupForm);
		// validateメソッドを使い入力チェックを行う。
		assertFalse(signupForm.getPassword().matches(("[a-z0-9]{8,20}")));
	}

	@Test
	public void No11＿パスワード_半角数字＿全角ひら() {
		signupForm.password = "あああああああああ1111111111";
		Set<ConstraintViolation<SignupForm>> violations = validator.validate(signupForm);
		// validateメソッドを使い入力チェックを行う。
		assertFalse(signupForm.getPassword().matches(("[a-z0-9]{8,20}")));
	}

	@Test
	public void No12＿パスワード_半角数字_全角カナ() {
		signupForm.password = "アアアアアアアアアアア1111111111";
		Set<ConstraintViolation<SignupForm>> violations = validator.validate(signupForm);
		// validateメソッドを使い入力チェックを行う。
		assertFalse(signupForm.getPassword().matches(("[a-z0-9]{8,20}")));
	}

	@Test
	public void No13＿パスワード_半角数字_全角アルファベット() {
		signupForm.password = "ａａａａａａａａａ111111111";
		Set<ConstraintViolation<SignupForm>> violations = validator.validate(signupForm);
		// validateメソッドを使い入力チェックを行う。
		assertFalse(signupForm.getPassword().matches(("[a-z0-9]{8,20}")));
	}

	@Test
	public void No14＿パスワード_半角数字_全角記号() {
		signupForm.password = "／／／／／／111111111";
		Set<ConstraintViolation<SignupForm>> violations = validator.validate(signupForm);
		// validateメソッドを使い入力チェックを行う。
		assertFalse(signupForm.getPassword().matches(("[a-z0-9]{8,20}")));
	}

	@Test
	public void No15＿パスワード_半角数字_全角数字() {
		signupForm.password = "1111111１１１１１１";
		Set<ConstraintViolation<SignupForm>> violations = validator.validate(signupForm);
		// validateメソッドを使い入力チェックを行う。
		assertFalse(signupForm.getPassword().matches(("[a-z0-9]{8,20}")));

	}

	@Test
	public void No16＿パスワード_半角数字_半角カナ() {
		signupForm.password = "ｱｱｱｱｱｱｱｱ11111111111";
		Set<ConstraintViolation<SignupForm>> violations = validator.validate(signupForm);
		// validateメソッドを使い入力チェックを行う。
		assertFalse(signupForm.getPassword().matches(("[a-z0-9]{8,20}")));
	}

	@Test
	public void No17＿パスワード_半角数字_半角記号() {
		signupForm.password = "///////1111111111";
		Set<ConstraintViolation<SignupForm>> violations = validator.validate(signupForm);
		// validateメソッドを使い入力チェックを行う。
		assertFalse(signupForm.getPassword().matches(("[a-z0-9]{8,20}")));
	}

	@Test
	public void No18＿パスワード_半角数字_絵文字() {
		signupForm.password = "🌸🌸🌸🌸11111111111";
		Set<ConstraintViolation<SignupForm>> violations = validator.validate(signupForm);
		// validateメソッドを使い入力チェックを行う。
		assertFalse(signupForm.getPassword().matches(("[a-z0-9]{8,20}")));
	}

	@Test
	public void No19＿パスワード_半角アルファベット_全角ひら() {
		signupForm.password = "あああaaaaaaaaaaaaa";
		Set<ConstraintViolation<SignupForm>> violations = validator.validate(signupForm);
		// validateメソッドを使い入力チェックを行う。
		assertFalse(signupForm.getPassword().matches(("[a-z0-9]{8,20}")));
	}

	@Test
	public void No20＿パスワード_半角アルファベット_全角カナ() {
		signupForm.password = "アアアaaaaaaaaaaaaaa";
		Set<ConstraintViolation<SignupForm>> violations = validator.validate(signupForm);
		// validateメソッドを使い入力チェックを行う。
		assertFalse(signupForm.getPassword().matches(("[a-z0-9]{8,20}")));
	}

	@Test
	public void No21＿パスワード_半角アルファベット_全角アルファベット() {
		signupForm.password = "ａａａａａａａaaaaa";
		Set<ConstraintViolation<SignupForm>> violations = validator.validate(signupForm);
		// validateメソッドを使い入力チェックを行う。
		assertFalse(signupForm.getPassword().matches(("[a-z0-9]{8,20}")));
	}

	@Test
	public void No22＿パスワード_半角アルファベット_全角記号() {
		signupForm.password = "／／／aaaaaaaaaaaaaaa";
		Set<ConstraintViolation<SignupForm>> violations = validator.validate(signupForm);
		// validateメソッドを使い入力チェックを行う。
		assertFalse(signupForm.getPassword().matches(("[a-z0-9]{8,20}")));
	}

	@Test
	public void No23＿パスワード_半角アルファベット_全角数字() {
		signupForm.password = "１１１１aaaaaaaaaaaaaaa";
		Set<ConstraintViolation<SignupForm>> violations = validator.validate(signupForm);
		// validateメソッドを使い入力チェックを行う。
		assertFalse(signupForm.getPassword().matches(("[a-z0-9]{8,20}")));
	}

	@Test
	public void No24＿パスワード_半角アルファベット_半角カナ() {
		signupForm.password = "ｱｱｱｱaaaaaaa";
		Set<ConstraintViolation<SignupForm>> violations = validator.validate(signupForm);
		// validateメソッドを使い入力チェックを行う。
		assertFalse(signupForm.getPassword().matches(("[a-z0-9]{8,20}")));
	}

	@Test
	public void No25＿パスワード_半角アルファベット_半角記号() {
		signupForm.password = "///////aaaaaa";
		Set<ConstraintViolation<SignupForm>> violations = validator.validate(signupForm);
		// validateメソッドを使い入力チェックを行う。
		assertFalse(signupForm.getPassword().matches(("[a-z0-9]{8,20}")));
	}

	@Test
	public void No26＿パスワード_半角アルファベット_絵文字() {
		signupForm.password = "🌸🌸🌸🌸aaaaaaa";
		Set<ConstraintViolation<SignupForm>> violations = validator.validate(signupForm);
		// validateメソッドを使い入力チェックを行う。
		assertFalse(signupForm.getPassword().matches(("[a-z0-9]{8,20}")));
	}

	@Test
	public void No27＿パスワード_半角数字_半角アルファベット() {
		signupForm.password = "11111111111aaaaaa";
		Set<ConstraintViolation<SignupForm>> violations = validator.validate(signupForm);
		// validateメソッドを使い入力チェックを行う。
		assertTrue(signupForm.getPassword().matches(("[a-z0-9]{8,20}")));
	}

	@Test
	public void No28＿パスワード_文字数21字() {
		signupForm.password = "aaaaaaaaa1aaaaaaaaa2a";
		Set<ConstraintViolation<SignupForm>> violations = validator.validate(signupForm);
		// validateメソッドを使い入力チェックを行う。
		assertFalse(signupForm.getPassword().matches(("[a-z0-9]{8,20}")));
	}

	@Test
	public void No29＿パスワード_文字数20字() {
		signupForm.password = "aaaaaaaaa1aaaaaaaaa2";
		Set<ConstraintViolation<SignupForm>> violations = validator.validate(signupForm);
		// validateメソッドを使い入力チェックを行う。
		assertTrue(signupForm.getPassword().matches(("[a-z0-9]{8,20}")));
	}

	@Test
	public void No30＿パスワード_文字数19字() {
		signupForm.password = "aaaaaaaaa1aaaaaaaaa";
		Set<ConstraintViolation<SignupForm>> violations = validator.validate(signupForm);
		// validateメソッドを使い入力チェックを行う。
		assertTrue(signupForm.getPassword().matches(("[a-z0-9]{8,20}")));
	}

	@Test
	public void No31＿パスワード_文字数９字() {
		signupForm.password = "aaaaaaaa9";
		Set<ConstraintViolation<SignupForm>> violations = validator.validate(signupForm);
		// validateメソッドを使い入力チェックを行う。
		assertTrue(signupForm.getPassword().matches(("[a-z0-9]{8,20}")));
	}

	@Test
	public void No32＿パスワード_文字数8字() {
		signupForm.password = "aaaaaaa8";
		Set<ConstraintViolation<SignupForm>> violations = validator.validate(signupForm);
		// validateメソッドを使い入力チェックを行う。
		assertTrue(signupForm.getPassword().matches(("[a-z0-9]{8,20}")));
	}

	@Test
	public void No33＿パスワード_文字数7字() {
		signupForm.password = "aaaaaa7";
		Set<ConstraintViolation<SignupForm>> violations = validator.validate(signupForm);
		// validateメソッドを使い入力チェックを行う。
		assertFalse(signupForm.getPassword().matches(("[a-z0-9]{8,20}")));
	}
}

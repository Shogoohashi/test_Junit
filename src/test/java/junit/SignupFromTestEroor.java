package junit;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThanOrEqualTo;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.junit.Before;
import org.junit.Test;
import org.junit.rules.TestName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;

import com.example.demo.login.domain.model.SignupForm;

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
	// 異常系テスト
	//
	@Test(expected = NullPointerException.class)
	public void No1_異常系_ユーザID() {
		testsignupForm.setUserId(null);
		validator.validate(testsignupForm, bindingResult);
		assertThat(bindingResult.getFieldError().getField(), is("userId"));
		assertThat(bindingResult.getFieldError().getDefaultMessage(), is("メールアドレスではありません"));
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
	
	@Test(expected = NullPointerException.class)
	public void No５＿異常系_未入力() throws Error  {
		testsignupForm.setBirthday  = new TestName();
		LocalDate TestName = LocalDate.of(2020,1,1);
		LocalDate TestBirthday = LocalDate.parse("2013/07/07", DateTimeFormatter.ofPattern(null));
		assertThat(TestName.isEqual(TestBirthday));		
		
	}
	@Test(expected = Exception.class)
	public void No6＿異常系_全角英数() throws Error  {
		testsignupForm.setBirthday  = new TestName();
		LocalDate TestName = LocalDate.of(2020,1,1);
		LocalDate TestBirthday = LocalDate.parse("2013/07/07", DateTimeFormatter.ofPattern("YYYY／MM／DD"));
		assertThat(TestName.isEqual(TestBirthday));		
		
	}
	@Test(expected = Exception.class)
	public void No7＿異常系_全角数字() throws Error  {
		testsignupForm.setBirthday  = new TestName();
		LocalDate TestName = LocalDate.of(2020,1,1);
		LocalDate TestBirthday = LocalDate.parse("２０１１/１１/２２", DateTimeFormatter.ofPattern("yyyy/MM/dd"));
		assertThat(TestName.isEqual(TestBirthday));		
		
	}
	
	@Test(expected = AssertionError.class)
	public void No８＿異常系＿19際以下() {
		testsignupForm.setAge(19);
		assertThat(testsignupForm.getAge(), is(greaterThanOrEqualTo(20)));
	}
	@Test(expected = NullPointerException.class)
	public void No9＿異常系＿既婚() {
		SignupForm testmarriage = new SignupForm();
		assertThat(testmarriage).matches(null, "未婚");
	}
}

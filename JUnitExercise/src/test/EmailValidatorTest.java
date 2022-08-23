package test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import com.infy.exception.InfyAcademyException;

import application.EmailValidator;

public class EmailValidatorTest {
	
	public static EmailValidator emailValidator;
	
	@BeforeEach
	void setUp() throws Exception {
		emailValidator = new EmailValidator();
	}

	@AfterEach
	void tearDown() throws Exception {
		emailValidator = null;
	}
	
	@Test
	public void validateEmailIdValidEmailId() throws InfyAcademyException {
		assertTrue("Invalid Mail Id",emailValidator.validateEmailId("James_Potter@infy.com"));
	}

	@Test
	public void validateEmailIdInvalidEmailId() throws InfyAcademyException {
		assertFalse("Valid Mail Id",emailValidator.validateEmailId("James_Potter@infy.org"));
	}

	@Test
	public void validateEmailIdInvalidEmailIdException() throws InfyAcademyException {
		assertThrows(InfyAcademyException.class, ()->emailValidator.validateEmailId(""),"Its a valid Email");
	}
	
	@ParameterizedTest
	@ValueSource(strings = {"Sirius_Black","Lily_Evans@Hoggy.in","Remus_Lups","NymphieTonks@magic.com"})
	public void validateEmailIdParamterizedEmailId(String emailId) throws InfyAcademyException {
		assertTrue(emailValidator.validateEmailId(emailId));
	}
}

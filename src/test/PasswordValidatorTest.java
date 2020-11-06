package test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;

import validation.PasswordValidator;
public class PasswordValidatorTest {
	
	/*
	 * a valid password should be at least 6 characters
	 * 
	 * a valid password should not contain spaces
	 * 
	 */

	@Test
	public void validPasswordShouldBeAtLeast6Characters() {
		assertTrue(PasswordValidator.passwordValidator("123heihå"));
		assertTrue(PasswordValidator.passwordValidator("123456"));
		assertTrue(PasswordValidator.passwordValidator("passord"));
	}
	
	@Test
	public void passwordsLessThan6CharactersShouldNotBeOK() {
		assertFalse(PasswordValidator.passwordValidator("123")); 
		assertFalse(PasswordValidator.passwordValidator("1"));
		assertFalse(PasswordValidator.passwordValidator("heihå"));
		assertFalse(PasswordValidator.passwordValidator(""));
		assertFalse(PasswordValidator.passwordValidator(null)); 
		
	}
	
	@Test
	public void passwordShouldNotContainSpacing() {
		assertFalse(PasswordValidator.passwordValidator("123 hei"));
		assertFalse(PasswordValidator.passwordValidator(" pass")); 
	}
}

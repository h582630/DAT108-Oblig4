package test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;
import validation.ParticipantValidator;

public class ParticipantValidatorTest {
	
	/*
	 * a valid participant should have big first letter in first and second name 
	 * 
	 * a valid participant should have between 2 and 21 letters in name 
	 * 
	 * a valid participant should have only letters, hyphen and space in first-name
	 * 
	 * a valid participant should have only letters and hypen in second name 
	 * 
	 * a valid participant should have a phonenumber with 8 digits
	 * 
	 * a valid participant should be able to have norwegian letters in name
	 */

	@Test
	public void validFirstNamesShouldBeOk() {
		assertTrue(ParticipantValidator.firstNameValidator("Even")); 
		assertTrue(ParticipantValidator.firstNameValidator("Even-Ask"));
	    assertTrue(ParticipantValidator.firstNameValidator("Even Ask")); 
	 
	}
	
	@Test
	public void validSecondNameShouldBeOk() {
		assertTrue(ParticipantValidator.lastNameValidator("Sleire")); 
		assertTrue(ParticipantValidator.lastNameValidator("Sleire-Hansen"));
		assertTrue(ParticipantValidator.lastNameValidator("Ole-Olsen")); 
	}
	
	@Test
	public void validNamesCouldContainNorwegianLetters() {
		
		assertTrue(ParticipantValidator.firstNameValidator("Åge"));
		assertTrue(ParticipantValidator.firstNameValidator("Øystein"));
		assertTrue(ParticipantValidator.firstNameValidator("Ælvin"));
		
		assertTrue(ParticipantValidator.lastNameValidator("Ørnsnes"));
		assertTrue(ParticipantValidator.lastNameValidator("Årvik"));
		assertTrue(ParticipantValidator.lastNameValidator("Ækeli"));
		
	
		
	}
	@Test
	public void validPhoneNumberShouldBeOk() {
		assertTrue(ParticipantValidator.phoneNumberValidator("90040823")); 
		assertTrue(ParticipantValidator.phoneNumberValidator("40408080"));
		assertTrue(ParticipantValidator.phoneNumberValidator("32232312"));
	}
	
	@Test
	public void phoneNumbersShorterOrLongerThan8DigtitsShouldNotBeOK() {
		assertFalse(ParticipantValidator.phoneNumberValidator("900408231")); 
		assertFalse(ParticipantValidator.phoneNumberValidator("900408231221"));
		assertFalse(ParticipantValidator.phoneNumberValidator("900"));
		assertFalse(ParticipantValidator.phoneNumberValidator("1"));
		assertFalse(ParticipantValidator.phoneNumberValidator("12"));
	}
	@Test
	public void shortFirstAndSecondNamesShouldNotBeOK() {
		assertFalse(ParticipantValidator.firstNameValidator(""));
		assertFalse(ParticipantValidator.firstNameValidator("a"));
		assertFalse(ParticipantValidator.firstNameValidator("A"));
		assertFalse(ParticipantValidator.firstNameValidator(null)); 
		
		
		assertFalse(ParticipantValidator.lastNameValidator(""));
		assertFalse(ParticipantValidator.lastNameValidator("a"));
		assertFalse(ParticipantValidator.lastNameValidator("A"));
		assertFalse(ParticipantValidator.lastNameValidator(null));
		
	}
	
	@Test
	public void longFirstAndSecondNamesShouldNotBeOK() {
		assertFalse(ParticipantValidator.firstNameValidator("Evensleirefridtjofhansenfritzen"));
		
		assertFalse(ParticipantValidator.lastNameValidator("Evensleirefridtjofhansenfritzen"));
		
	}
	
	@Test
	public void secondNamesThatContainsSpaceShouldNotBeOK() {
		assertFalse(ParticipantValidator.lastNameValidator("Aker Hansen")); 
	}
	
	@Test
	public void namesThatStartsWithALowerCaseShouldNotBeOK() {
		assertFalse(ParticipantValidator.firstNameValidator("ole")); 
		
		// second name
		assertFalse(ParticipantValidator.lastNameValidator("hansen")); 
	}
	

}

package validation;

import java.util.List;

import models.Participant;

public class ParticipantValidator {

	public static final String ANY_LETTER = "[a-zA-ZÊ¯Â∆ÿ≈-]";
	public static final String ONLY_DIGITS = "[0-9]";

	public static boolean firstNameValidator(String firstName) { // MÂ fikse for mellomrom osv.

		return validateName(firstName);
	}

	public static boolean lastNameValidator(String lastName) {

		return validateName(lastName) && !lastName.contains(" ");
	}



	public static boolean phoneNumberValidator(String number) {

		if (number.length() != 8) {
			return false;
		} else if (number.matches(ONLY_DIGITS)) {
			return false;
		}
		return true;

	}
	
	public static boolean checkExistingPhone(List<Participant> listOfParticipants, String existingNumber) {
		
		for(Participant p : listOfParticipants) {
			if(p.getPhoneNumber().equals(existingNumber)) {
				return false; 
			}
		}
		return true;
	}

	private static boolean validateName(String name) {

		if(name == null) {
			return false; 
		} else if (name.equals("")) {
			return false;
		} else if (!Character.isUpperCase(name.charAt(0))) {
			return false;
		} else if (name.length() < 2 || name.length() > 21) {
			return false;
		} else if (name.matches(ANY_LETTER)) {
			return false;
		}

		return true;
	}
	
	
	
}

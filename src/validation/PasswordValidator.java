package validation;

public class PasswordValidator {

	public static boolean passwordValidator(String password) {

		if (password == null) {
			return false; 
		} else if (password.length() < 6) {
			return false;
		} else if (password.contains(" ")) {
			return false;
		}

		return true;

	}

}

package services;

public class FormatPhoneNumber {
	
	public static String formatPhoneNumber(String number) {
		String formattedNumber;

		char[] charList = number.toCharArray();

		formattedNumber = charList[0] + "" + charList[1] + "" + charList[2] + " " + charList[3] + charList[4] + " " + charList[5]
				+ charList[6] + charList[7];

		return formattedNumber;
	}

}

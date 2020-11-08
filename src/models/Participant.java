package models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(schema = "oblig4", name = "participant")
public class Participant {

	@Id
	private String phoneNumber;
	private String firstName;
	private String lastName;
	private String password_hash;
	private String password_salt; 
	private String sex;

	public Participant() {

	}

	public Participant(String firstName, String secondName, String phoneNumber, String password, String sex, String salt) {
		this.firstName = firstName;
		this.lastName = secondName;
		this.phoneNumber = phoneNumber;
		this.password_hash = password;
		this.password_salt = salt; 
		this.sex = sex;

	}

	public String getPhoneNumber() {

		String formattedNumber;

		char[] charList = phoneNumber.toCharArray();

		formattedNumber = charList[0] + "" + charList[1] + "" + charList[2] + " " + charList[3] + charList[4] + " " + charList[5]
				+ charList[6] + charList[7];

		return formattedNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPassword_hash() {
		return password_hash;
	}

	public void setPassword(String password) {
		this.password_hash = password;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}
	
	public String getPassword_salt() {
		return password_salt;
	}

	public void setPassword_salt(String password_salt) {
		this.password_salt = password_salt;
	}

	

	@Override
	public String toString() {
		return "Participant [phoneNumber=" + phoneNumber + ", firstName=" + firstName
				+ ", secondName=" + lastName + ", password=" + password_hash + ", sex=" + sex + "]";
	}

}

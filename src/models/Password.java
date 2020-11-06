package models;

import javax.persistence.Embeddable;
import services.PassordService;

@Embeddable
public class Password {

	private String pwd_hash;
    private String pwd_salt;
    
	private Password(String hash, String salt) {
		pwd_hash = hash;
		pwd_salt = salt;
	}
	
	public Password() {}

	@Override
	public String toString() {
		return "Passord [pwd_hash=" + pwd_hash + ", pwd_salt=" + pwd_salt + "]";
	}

	public static Password lagPassord(String passordKlartekst) {
		String salt = PassordService.genererTilfeldigSalt();
		String hash = PassordService.hashMedSalt2(passordKlartekst, salt);
		return new Password(hash, salt);
	}
}

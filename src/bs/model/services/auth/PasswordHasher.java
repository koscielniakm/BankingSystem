package bs.model.services.auth;

import java.security.NoSuchAlgorithmException;

public class PasswordHasher {

	public static String hashPassword(String password) {
		try {
			password = ShaHasher.hashSha256(password);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return password;
	}
	
}

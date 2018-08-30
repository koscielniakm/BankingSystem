package bs.model.services.security;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Md5Hasher {

	public static String hashMD5(String text) throws NoSuchAlgorithmException {
		MessageDigest digest = MessageDigest.getInstance("MD5");
		digest.update(text.getBytes());
		byte messageDigest[] = digest.digest();
		StringBuilder hexString = new StringBuilder();
		for (byte b : messageDigest)
			hexString.append(Integer.toHexString(0xFF & b));
        return hexString.toString();
	}
	
}

package bs.model.services.security;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

class ShaHasher {

    public static String hashSha256(String password) throws NoSuchAlgorithmException {
    	MessageDigest md = MessageDigest.getInstance("SHA-256");
    	md.update(password.getBytes());
    	return bytesToHex(md.digest());
    }
    
    public static String bytesToHex(byte[] bytes) {
    	StringBuffer result = new StringBuffer();
        for (byte b : bytes) result.append(Integer.toString((b & 0xff) + 0x100, 16).substring(1));
        return result.toString();
	}
	
}

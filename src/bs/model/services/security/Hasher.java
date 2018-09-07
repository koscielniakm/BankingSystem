package bs.model.services.security;

import java.security.NoSuchAlgorithmException;

/**
 * Facade for many hash types.
 * Hash string by selected algorithm.
 * @author Mateusz
 */
public class Hasher {

	/**
	 * @param value Some string.
	 * @return Param string hashsed by MD5.
	 */
	public static String hashMd5(String value) {
		try
		{
			value = Md5Hasher.hashMD5(value);
		}
		catch (NoSuchAlgorithmException e)
		{
			e.printStackTrace();
			return null;
		}
		return value;
	}
	
	/**
	 * @param value Some string.
	 * @return Param string hashsed by SHA-256.
	 */
	public static String hashSha256(String value) {
		try
		{
			value = ShaHasher.hashSha256(value);
		}
		catch (NoSuchAlgorithmException e)
		{
			e.printStackTrace();
			return null;
		}
		return value;
	}
	
}

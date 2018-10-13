package bs.model.services.token;

import java.security.Key;

import javax.crypto.spec.SecretKeySpec;

import bs.model.config.Finals;

public class TokenKeyGeneratorImpl implements TokenKeyGenerator {

	private static final byte[] TOKEN_SECRET = "Yn2kjibddFAWtnPJ2AFlL8WXmohJMCvigQggaEypa5E=".getBytes();
	
	private static final Key TOKEN_KEY = new SecretKeySpec(TOKEN_SECRET, Finals.JWT_SIGNATURE_ALGORITHM.getJcaName());

	@Override
	public Key generateKey() {
		return TOKEN_KEY;
	}
	
}

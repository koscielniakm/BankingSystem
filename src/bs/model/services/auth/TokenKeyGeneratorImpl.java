package bs.model.services.auth;

import java.security.Key;

import javax.crypto.spec.SecretKeySpec;

import io.jsonwebtoken.SignatureAlgorithm;

public class TokenKeyGeneratorImpl implements TokenKeyGenerator {

	private static final SignatureAlgorithm SIGNATURE_ALGORITHM = SignatureAlgorithm.HS256;
	
	private static final byte[] TOKEN_SECRET = "Yn2kjibddFAWtnPJ2AFlL8WXmohJMCvigQggaEypa5E=".getBytes();
	
	private static final Key TOKEN_KEY = new SecretKeySpec(TOKEN_SECRET, SIGNATURE_ALGORITHM.getJcaName());

	@Override
	public Key generateKey() {
		return TOKEN_KEY;
	}
	
}

package bs.model.services.security;


import java.security.Key;
import java.time.Instant;
import java.util.Date;

import javax.crypto.spec.SecretKeySpec;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public final class TokenManager {

	private static final SignatureAlgorithm SIGNATURE_ALGORITHM = SignatureAlgorithm.HS256;
	
	private static final byte[] TOKEN_SECRET = "Yn2kjibddFAWtnPJ2AFlL8WXmohJMCvigQggaEypa5E=".getBytes();
	
	private static final Key TOKEN_KEY = new SecretKeySpec(TOKEN_SECRET, SIGNATURE_ALGORITHM.getJcaName());

	public static String build(Integer accountNumber) {
		return Jwts.builder()
			.setIssuer(accountNumber.toString())
			.setSubject("Subject")
			.setIssuedAt(Date.from(Instant.ofEpochSecond(new Date().getTime())))
			.setExpiration(Date.from(Instant.ofEpochSecond(new Date().getTime())))
			.signWith(SIGNATURE_ALGORITHM, TOKEN_KEY)
			.compact();
	}
	
	private static Claims decode(String token) {
		return Jwts.parser()
			.setSigningKey(TOKEN_SECRET)
			.parseClaimsJws(token).getBody();
	}
	
	public static Integer decodeAccountNumber(String token) {
		return Integer.parseUnsignedInt(decode(token).getIssuer());
	}
	
	public static boolean isExpired(String token) {
		Date expireDate = decode(token).getExpiration();
		return new Date().after(expireDate) ? false : true;
	}
	
}

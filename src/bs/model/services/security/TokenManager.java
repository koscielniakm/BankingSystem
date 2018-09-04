package bs.model.services.security;

import java.time.Instant;
import java.util.Date;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.impl.TextCodec;

public class TokenManager {

	public static String build(Integer accountNumber) {
		return Jwts.builder()
			.setIssuer(accountNumber.toString())
			.setSubject("Subject")
			.setIssuedAt(Date.from(Instant.ofEpochSecond(new Date().getTime())))
			.setExpiration(Date.from(Instant.ofEpochSecond(new Date().getTime())))
			.signWith(
				SignatureAlgorithm.HS256,
				TextCodec.BASE64.decode("Yn2kjibddFAWtnPJ2AFlL8WXmohJMCvigQggaEypa5E=")
			)
			.compact();
	}
	
	public static Claims decode(String token) {
		return (Jwts.parser()
		.setSigningKey(TextCodec.BASE64.decode("Yn2kjibddFAWtnPJ2AFlL8WXmohJMCvigQggaEypa5E="))
		.parseClaimsJws(token).getBody());
	}
	
}

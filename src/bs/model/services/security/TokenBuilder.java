package bs.model.services.security;

import java.time.Instant;
import java.util.Date;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.impl.TextCodec;

public class TokenBuilder {

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
	
}

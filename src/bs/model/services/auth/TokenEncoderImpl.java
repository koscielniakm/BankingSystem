package bs.model.services.auth;

import java.security.Key;
import java.time.Instant;
import java.util.Date;

import bs.model.config.Finals;
import io.jsonwebtoken.Jwts;

public class TokenEncoderImpl {

	private Key key;
	
	public TokenEncoderImpl() {
		this.key = new TokenKeyGeneratorImpl().generateKey();
	}
	
	public String encode(UserAuthData userData) {
		Date dateNow = new Date();
		Date expirationDate = new Date(dateNow.getTime() + Finals.JWT_EXPIRANTION_MILIS);
		return Jwts.builder()
			.setId(userData.getUserId().toString())
			.setIssuedAt(Date.from(Instant.ofEpochSecond(dateNow.getTime())))
			.setExpiration(Date.from(Instant.ofEpochSecond(expirationDate.getTime())))
			.signWith(Finals.JWT_SIGNATURE_ALGORITHM, key)
			.compact();
	}
	
}

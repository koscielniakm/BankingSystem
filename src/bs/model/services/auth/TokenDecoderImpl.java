package bs.model.services.auth;

import java.security.Key;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

public class TokenDecoderImpl implements TokenDecoder {

	private Key key;
	
	public TokenDecoderImpl() {
		this.key = new TokenKeyGeneratorImpl().generateKey();
	}
	
	public UserAuthData decode(String token) {
		Claims tokenClaims = Jwts.parser()
			.setSigningKey(key)
			.parseClaimsJws(token)
			.getBody();
		UserAuthData userData = new UserAuthDataImpl(Integer.parseInt(tokenClaims.getId()));
		return userData;
	}
	
}

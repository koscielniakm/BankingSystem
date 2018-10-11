package bs.model.services.auth;

public interface TokenEncoder {
	
	/**
	 * Should generate token with logged user data.
	 * @return Encoded token.
	 */
	public String encode(UserAuthData authData);
	
}

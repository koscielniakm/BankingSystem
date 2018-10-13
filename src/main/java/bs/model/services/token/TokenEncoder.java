package bs.model.services.token;

public interface TokenEncoder {
	
	/**
	 * Should generate token with logged user data.
	 * @return Encoded token.
	 */
	public String encode(UserAuthData authData);
	
}

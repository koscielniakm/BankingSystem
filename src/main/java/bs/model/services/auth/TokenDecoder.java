package bs.model.services.auth;

public interface TokenDecoder {

	/**
	 * 
	 * @return Status of token validation.
	 */
	public UserAuthData decode(String token);
	
}

package bs.model.services.token;

public interface TokenDecoder {

	/**
	 * 
	 * @return Status of token validation.
	 */
	public UserAuthData decode(String token);
	
}

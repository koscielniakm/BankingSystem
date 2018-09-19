package bs.model.services.auth;

import java.security.Key;

/**
 * Generate key for token.
 * @author Mateusz
 */
public interface TokenKeyGenerator {

	public Key generateKey();
	
}

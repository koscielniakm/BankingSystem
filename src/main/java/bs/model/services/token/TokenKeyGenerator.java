package bs.model.services.token;

import java.security.Key;

/**
 * Generate key for token.
 * @author Mateusz
 */
public interface TokenKeyGenerator {

	public Key generateKey();
	
}

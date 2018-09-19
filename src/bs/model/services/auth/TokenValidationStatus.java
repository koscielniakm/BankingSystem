package bs.model.services.auth;

/**
 * Possible status of token validation.
 * @author Mateusz
 */
public enum TokenValidationStatus {
	SUCCESS,
	INVALID_TOKEN,
	EXPIRED_TOKEN,
	/* ... */
}

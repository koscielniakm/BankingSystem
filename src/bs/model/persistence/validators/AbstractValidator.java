package bs.model.persistence.validators;

/**
 * Superclass for DAO validators.
 * @author Mateusz
 */
public abstract class AbstractValidator {

	/**
	 * Check if object is not null.
	 * @param object Some object.
	 * @return Result of validation.
	 */
	protected static boolean validateNotNull(Object object) {
		return object == null ? false : true;
	}
	
	/**
	 * Check for correct ID.
	 * @param id ID of entity.
	 * @return Result of validation.
	 */
	protected static boolean validateId(Integer id) {
		return id == null || id < 0 ? false : true;
	}
	
}

package bs.model.persistence.validators;

public abstract class AbstractValidator {

	protected static boolean validateNotNull(Object object) {
		return object == null ? false : true;
	}
	
	protected static boolean validateId(Integer id) {
		return id == null || id < 0 ? false : true;
	}
	
}

package bs.model.persistence.validators;

public abstract class AbstractValidator {

	protected static boolean validateNotNull(Object object) {
		return object == null ? false : true;
	}
	
}

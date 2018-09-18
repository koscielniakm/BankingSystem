package bs.model.persistence.validators;

import java.util.ArrayList;
import java.util.List;

import bs.model.config.Finals;
import bs.model.persistence.entities.PersonEntity;

public class PersonValidatorImpl extends AbstractValidator implements DaoValidator<PersonEntity> {

	@Override
	public boolean validateBeforeCreate(PersonEntity person) {
		return getValidationResult(getValidationsBeforeCreate(person));
	}

	private List<Boolean> getValidationsBeforeCreate(PersonEntity entity) {
		List<Boolean> validationList = new ArrayList<>();
		validationList.add(validateNotNull(entity.getFirstName()));
		validationList.add(validateNotNull(entity.getLastName()));
		validationList.add(validateFirstNameLength(entity.getFirstName()));
		validationList.add(validateLastNameLength(entity.getLastName()));
		return validationList;
	}
	
	@Override
	public boolean validateBeforeUpdate(PersonEntity person) {
		return getValidationResult(getValidationsBeforeUpdate(person));
	}

	private List<Boolean> getValidationsBeforeUpdate(PersonEntity entity) {
		List<Boolean> validationList = new ArrayList<>();
		validationList.add(validateNotNull(entity.getId()));
		validationList.add(validateNotNull(entity.getFirstName()));
		validationList.add(validateNotNull(entity.getLastName()));
		validationList.add(validateFirstNameLength(entity.getFirstName()));
		validationList.add(validateLastNameLength(entity.getLastName()));
		return validationList;
	}
	
	@Override
	public boolean validateBeforeDelete(Integer id) {
		return validateId(id);
	}
	
	private boolean validateFirstNameLength(String firstName) {
		Integer maxLength = Finals.DB_PERSON_FIRSTNAME_MAX_LENGTH;
		return firstName.length() > maxLength ? false : true;
	}
	
	private boolean validateLastNameLength(String lastName) {
		Integer maxLength = Finals.DB_PERSON_LASTNAME_MAX_LENGTH;
		return lastName.length() > maxLength ? false : true;	
	}
	
}

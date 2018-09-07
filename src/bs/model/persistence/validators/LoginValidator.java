package bs.model.persistence.validators;

import java.util.ArrayList;
import java.util.List;

import bs.model.persistence.entities.LoginEntity;

public class LoginValidator extends AbstractValidator implements DaoValidator<LoginEntity> {

	@Override
	public boolean validateBeforeCreate(LoginEntity entity) {
		return getValidationResult(getValidationsBeforeCreate(entity));
	}
	
	private List<Boolean> getValidationsBeforeCreate(LoginEntity entity) {
		List<Boolean> validationList = new ArrayList<>();
		validationList.add(validateNotNull(entity.getInput()));
		validationList.add(validateNotNull(entity.getDate()));
		validationList.add(validateNotNull(entity.getIp()));
		return validationList;
	}

	@Override
	public boolean validateBeforeUpdate(LoginEntity entity) {
		return getValidationResult(getValidationsBeforeUpdate(entity));
	}
	
	private List<Boolean> getValidationsBeforeUpdate(LoginEntity entity) {
		List<Boolean> validationList = new ArrayList<>();
		validationList.add(validateNotNull(entity.getId()));
		validationList.add(validateNotNull(entity.getInput()));
		validationList.add(validateNotNull(entity.getDate()));
		validationList.add(validateNotNull(entity.getIp()));
		return validationList;
	}

	@Override
	public boolean validateBeforeDelete(Integer id) {
		return validateId(id);
	}
	
}

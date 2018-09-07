package bs.model.persistence.validators;

import bs.model.persistence.entities.LoginEntity;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class LoginValidator implements DaoValidator<LoginEntity> {

	@Override
	public boolean validateBeforeCreate(LoginEntity obj) {
		throw new NotImplementedException();
	}

	@Override
	public boolean validateBeforeUpdate(LoginEntity obj) {
		throw new NotImplementedException();
	}

	@Override
	public boolean validateBeforeDelete(Integer id) {
		throw new NotImplementedException();
	}
	
}

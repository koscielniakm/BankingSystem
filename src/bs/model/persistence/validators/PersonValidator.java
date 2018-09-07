package bs.model.persistence.validators;

import bs.model.persistence.entities.PersonEntity;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class PersonValidator implements DaoValidator<PersonEntity> {

	@Override
	public boolean validateBeforeCreate(PersonEntity person) {
		throw new NotImplementedException();
	}

	@Override
	public boolean validateBeforeUpdate(PersonEntity person) {
		throw new NotImplementedException();
	}

	@Override
	public boolean validateBeforeDelete(Integer id) {
		throw new NotImplementedException();
	}
	
}

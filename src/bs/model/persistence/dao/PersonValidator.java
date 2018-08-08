package bs.model.persistence.dao;

import bs.model.persistence.entities.PersonEntity;

public class PersonValidator implements DaoValidator<PersonEntity> {

	@Override
	public boolean validateBeforeCreate(PersonEntity person) {
		if (person == null) return false;
		if (validateFirstName(person.getFirstName()) &&
			validateLastName(person.getLastName()))
			return true;
		return false;
	}

	@Override
	public boolean validateBeforeUpdate(PersonEntity person) {
		if (person == null) return false;
		if (person.getId() > 0 &&
			validateFirstName(person.getFirstName()) &&
			validateLastName(person.getLastName()))
			return true;
		return false;
	}

	@Override
	public boolean validateBeforeDelete(Integer id) {
		if (id >= 0) return true;
		return false;
	}
	
	private boolean validateFirstName(String firstName) {
		if (firstName == null) return false;
		if (firstName == "") return false;
		else return true;
	}
	
	private boolean validateLastName(String lastName) {
		if (lastName == null) return false;
		if (lastName == "") return false;
		else return true;		
	}
	
}

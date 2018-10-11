package bs.model.persistence.dao;

import java.util.List;

import javax.persistence.EntityManager;

import bs.model.persistence.entities.PersonEntity;
import bs.model.persistence.validators.PersonValidator;

public class PersonDao extends AbstractDao<PersonEntity> implements Dao<PersonEntity>{
	
	private PersonValidator validator;
	
	public PersonDao() {
		validator = new PersonValidator();
	}
	
	@Override
	public boolean create(PersonEntity person) {
		if (!validator.validateBeforeCreate(person)) return false;
		super.persistEntity(person);
		return true;
	}

	@Override
	public boolean update(PersonEntity person) {
		if (!validator.validateBeforeUpdate(person)) return false;
		super.mergeEntity(person);
		return true;
	}

	@Override
	public boolean delete(int id) {
		if (!validator.validateBeforeDelete(id)) return false;
		super.removeEntity(PersonEntity.class, id);
		return false;
	}

	@Override
	public PersonEntity getById(int id) {
		EntityManager entityManager = getPersistenceSupport().getEntityManager();
		PersonEntity person = entityManager.find(PersonEntity.class, id);
		return person;
	}

	@Override
	public List<PersonEntity> getAll() {
		EntityManager entityManager = getPersistenceSupport().getEntityManager();
		List<PersonEntity> people = entityManager
			.createQuery("FROM PersonEntity p", PersonEntity.class).getResultList();
		return people;
	}

}

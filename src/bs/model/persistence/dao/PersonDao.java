package bs.model.persistence.dao;

import java.util.List;

import javax.persistence.EntityManager;

import bs.model.persistence.entities.Person;

public class PersonDao extends AbstractDao<Person> implements Dao<Person>{
	
	private PersonValidator validator;
	
	public PersonDao() {
		validator = new PersonValidator();
	}
	
	@Override
	public boolean create(Person person) {
		if (!validator.validateBeforeCreate(person)) return false;
		super.persistEntity(person);
		return true;
	}

	@Override
	public boolean update(Person person) {
		if (!validator.validateBeforeUpdate(person)) return false;
		super.mergeEntity(person);
		return true;
	}

	@Override
	public boolean delete(int id) {
		if (!validator.validateBeforeDelete(id)) return false;
		super.removeEntity(Person.class, id);
		return false;
	}

	@Override
	public Person getById(int id) {
		EntityManager entityManager = getPersistenceSupport().getEntityManager();
		Person person = entityManager.find(Person.class, id);
		return person;
	}

	@Override
	public List<Person> getAll() {
		EntityManager entityManager = getPersistenceSupport().getEntityManager();
		List<Person> people = entityManager
			.createQuery("FROM Person p", Person.class).getResultList();
		return people;
	}

}

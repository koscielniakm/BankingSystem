package bs.model.persistence.dao;

import java.util.List;

import javax.persistence.EntityManager;

import bs.model.persistence.entities.PersonEntity;

public class PersonDaoImpl extends AbstractDao<PersonEntity> implements PersonDao {

	@Override
	public PersonEntity create(PersonEntity obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PersonEntity update(PersonEntity obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean delete(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public PersonEntity getById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PersonEntity> getAll() {
		EntityManager entityManager = getEntityManager();
		List<PersonEntity> list = entityManager
			.createQuery("FROM PersonEntity p", PersonEntity.class).getResultList();
		return list;
	}

}

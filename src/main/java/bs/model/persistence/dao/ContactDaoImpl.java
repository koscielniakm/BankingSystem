package bs.model.persistence.dao;

import java.util.List;

import javax.persistence.EntityManager;

import bs.model.persistence.entities.ContactEntity;

public class ContactDaoImpl extends AbstractDao<ContactEntity> implements ContactDao {

	@Override
	public ContactEntity create(ContactEntity obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ContactEntity update(ContactEntity obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean delete(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ContactEntity getById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ContactEntity> getAll() {
		EntityManager entityManager = getEntityManager();
		List<ContactEntity> list = entityManager
			.createQuery("FROM ContactEntity c", ContactEntity.class).getResultList();
		return list;
	}

}

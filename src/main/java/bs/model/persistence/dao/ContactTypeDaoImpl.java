package bs.model.persistence.dao;

import java.util.List;

import javax.persistence.EntityManager;

import bs.model.persistence.entities.ContactTypeEntity;

public class ContactTypeDaoImpl extends AbstractDao<ContactTypeEntity> implements ContactTypeDao {

	@Override
	public ContactTypeEntity create(ContactTypeEntity obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ContactTypeEntity update(ContactTypeEntity obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean delete(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ContactTypeEntity getById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ContactTypeEntity> getAll() {
		EntityManager entityManager = getEntityManager();
		List<ContactTypeEntity> list = entityManager
			.createQuery("FROM ContactTypeEntity c", ContactTypeEntity.class).getResultList();
		return list;
	}

}

package bs.model.persistence.dao;

import java.util.List;

import javax.persistence.EntityManager;

import bs.model.persistence.entities.AddressTypeEntity;

public class AddressTypeDaoImpl extends AbstractDao<AddressTypeEntity> implements AddressTypeDao {

	@Override
	public AddressTypeEntity create(AddressTypeEntity obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AddressTypeEntity update(AddressTypeEntity obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean delete(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public AddressTypeEntity getById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<AddressTypeEntity> getAll() {
		EntityManager entityManager = getEntityManager();
		List<AddressTypeEntity> list = entityManager
			.createQuery("FROM AddressTypeEntity a", AddressTypeEntity.class).getResultList();
		return list;
	}

}

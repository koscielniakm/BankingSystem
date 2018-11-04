package bs.model.persistence.dao;

import java.util.List;

import javax.persistence.EntityManager;

import bs.model.persistence.entities.AddressEntity;

public class AddressDaoImpl extends AbstractDao<AddressEntity> implements AddressDao {

	@Override
	public AddressEntity create(AddressEntity obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AddressEntity update(AddressEntity obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean delete(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public AddressEntity getById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<AddressEntity> getAll() {
		EntityManager entityManager = getEntityManager();
		List<AddressEntity> list = entityManager
			.createQuery("FROM AddressEntity a", AddressEntity.class).getResultList();
		return list;
	}

}

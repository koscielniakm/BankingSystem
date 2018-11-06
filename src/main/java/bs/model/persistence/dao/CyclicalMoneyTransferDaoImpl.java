package bs.model.persistence.dao;

import java.util.List;

import javax.persistence.EntityManager;

import bs.model.persistence.entities.CyclicalMoneyTransferEntity;

public class CyclicalMoneyTransferDaoImpl extends AbstractDao<CyclicalMoneyTransferEntity> implements CyclicalMoneyTransferDao {

	@Override
	public CyclicalMoneyTransferEntity create(CyclicalMoneyTransferEntity obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CyclicalMoneyTransferEntity update(CyclicalMoneyTransferEntity obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean delete(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public CyclicalMoneyTransferEntity getById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CyclicalMoneyTransferEntity> getAll() {
		EntityManager entityManager = getEntityManager();
		List<CyclicalMoneyTransferEntity> list = entityManager
			.createQuery("FROM CyclicalMoneyTransferEntity c", CyclicalMoneyTransferEntity.class).getResultList();
		return list;
	}

}

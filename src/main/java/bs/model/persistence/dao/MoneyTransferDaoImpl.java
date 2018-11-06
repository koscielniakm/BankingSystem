package bs.model.persistence.dao;

import java.util.List;

import javax.persistence.EntityManager;

import bs.model.persistence.entities.MoneyTransferEntity;

public class MoneyTransferDaoImpl extends AbstractDao<MoneyTransferEntity> implements MoneyTransferDao {

	@Override
	public MoneyTransferEntity create(MoneyTransferEntity obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MoneyTransferEntity update(MoneyTransferEntity obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean delete(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public MoneyTransferEntity getById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<MoneyTransferEntity> getAll() {
		EntityManager entityManager = getEntityManager();
		List<MoneyTransferEntity> list = entityManager
			.createQuery("FROM MoneyTransferEntity m", MoneyTransferEntity.class).getResultList();
		return list;
	}
	
}

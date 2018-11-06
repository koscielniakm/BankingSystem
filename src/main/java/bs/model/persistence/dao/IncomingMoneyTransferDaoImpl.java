package bs.model.persistence.dao;

import java.util.List;

import javax.persistence.EntityManager;

import bs.model.persistence.entities.IncomingMoneyTransferEntity;

public class IncomingMoneyTransferDaoImpl extends AbstractDao<IncomingMoneyTransferEntity> implements IncomingMoneyTransferDao {

	@Override
	public IncomingMoneyTransferDao create(IncomingMoneyTransferDao obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IncomingMoneyTransferDao update(IncomingMoneyTransferDao obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean delete(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public IncomingMoneyTransferDao getById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<IncomingMoneyTransferDao> getAll() {
		EntityManager entityManager = getEntityManager();
		List<IncomingMoneyTransferDao> list = entityManager
			.createQuery("FROM IncomingMoneyTransferDao i", IncomingMoneyTransferDao.class).getResultList();
		return list;
	}

}

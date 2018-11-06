package bs.model.persistence.dao;

import java.util.List;

import javax.persistence.EntityManager;

import bs.model.persistence.entities.OutgoingMoneyTransferEntity;

public class OutgoingMoneyTransferDaoImpl extends AbstractDao<OutgoingMoneyTransferEntity> implements OutgoingMoneyTransferDao {

	@Override
	public OutgoingMoneyTransferEntity create(OutgoingMoneyTransferEntity obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public OutgoingMoneyTransferEntity update(OutgoingMoneyTransferEntity obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean delete(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public OutgoingMoneyTransferEntity getById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<OutgoingMoneyTransferEntity> getAll() {
		EntityManager entityManager = getEntityManager();
		List<OutgoingMoneyTransferEntity> list = entityManager
			.createQuery("FROM OutgoingMoneyTransferEntity o", OutgoingMoneyTransferEntity.class).getResultList();
		return list;
	}

}

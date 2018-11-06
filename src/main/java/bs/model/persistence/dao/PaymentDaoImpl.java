package bs.model.persistence.dao;

import java.util.List;

import javax.persistence.EntityManager;

import bs.model.persistence.entities.PaymentEntity;

public class PaymentDaoImpl extends AbstractDao<PaymentEntity> implements PaymentDao {

	@Override
	public PaymentEntity create(PaymentEntity obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PaymentEntity update(PaymentEntity obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean delete(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public PaymentEntity getById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PaymentEntity> getAll() {
		EntityManager entityManager = getEntityManager();
		List<PaymentEntity> list = entityManager
			.createQuery("FROM PaymentEntity p", PaymentEntity.class).getResultList();
		return list;
	}

}

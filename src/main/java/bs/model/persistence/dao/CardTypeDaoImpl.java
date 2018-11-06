package bs.model.persistence.dao;

import java.util.List;

import javax.persistence.EntityManager;

import bs.model.persistence.entities.CardTypeEntity;

public class CardTypeDaoImpl extends AbstractDao<CardTypeEntity> implements CardTypeDao {

	@Override
	public CardTypeEntity create(CardTypeEntity obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CardTypeEntity update(CardTypeEntity obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean delete(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public CardTypeEntity getById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CardTypeEntity> getAll() {
		EntityManager entityManager = getEntityManager();
		List<CardTypeEntity> list = entityManager
			.createQuery("FROM CardTypeEntity e", CardTypeEntity.class).getResultList();
		return list;
	}

}

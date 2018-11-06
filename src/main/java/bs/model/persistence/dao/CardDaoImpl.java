package bs.model.persistence.dao;

import java.util.List;

import javax.persistence.EntityManager;

import bs.model.persistence.entities.CardEntity;

public class CardDaoImpl extends AbstractDao<CardEntity> implements CardDao {

	@Override
	public CardEntity create(CardEntity obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CardEntity update(CardEntity obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean delete(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public CardEntity getById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CardEntity> getAll() {
		EntityManager entityManager = getEntityManager();
		List<CardEntity> list = entityManager
			.createQuery("FROM CardEntity c", CardEntity.class).getResultList();
		return list;
	}

	
}

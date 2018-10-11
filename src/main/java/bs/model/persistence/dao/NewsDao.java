package bs.model.persistence.dao;

import java.util.List;

import javax.persistence.EntityManager;

import bs.model.persistence.entities.NewsEntity;

public class NewsDao extends AbstractDao<NewsEntity> implements Dao<NewsEntity> {
	
	public NewsDao() {
		// TODO impl validator
	}
	
	@Override
	public boolean create(NewsEntity news) {
		super.persistEntity(news);
		return true;
	}

	@Override
	public boolean update(NewsEntity login) {
		super.mergeEntity(login);
		return true;
	}

	@Override
	public boolean delete(int id) {
		super.removeEntity(NewsEntity.class, id);
		return true;
	}

	@Override
	public NewsEntity getById(int id) {
		EntityManager entityManager = getPersistenceSupport().getEntityManager();
		NewsEntity login = entityManager.find(NewsEntity.class, id);
		return login;
	}

	@Override
	public List<NewsEntity> getAll() {
		EntityManager entityManager = getPersistenceSupport().getEntityManager();
		List<NewsEntity> list = entityManager
			.createQuery("FROM NewsEntity n", NewsEntity.class).getResultList();
		return list;
	}
	
	public List<NewsEntity> getLast(Integer number) {
		EntityManager entityManager = getPersistenceSupport().getEntityManager();
		List<NewsEntity> list = entityManager
			.createQuery("FROM NewsEntity n ORDER BY n.date DESC", NewsEntity.class)
			.setMaxResults(number)
			.getResultList();
		return list;
	}
	
}

package bs.model.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import bs.model.entities.DbEntity;

public /*abstract*/ class AbstractDao {

	private PersistenceSupport persistenceSupport;
	
	public AbstractDao() {
		persistenceSupport = new PersistenceSupport();
	}
	
	public boolean persistEntity(DbEntity entity) {
		EntityManager entityManager = persistenceSupport.getEntityManager();
		EntityTransaction currentTranslation = entityManager.getTransaction();
		currentTranslation.begin();
		entityManager.persist(entity);
		currentTranslation.commit();
		persistenceSupport.closeEntityManager();
		return true;
	}
	
	public boolean mergeEntity(DbEntity entity) {
		EntityManager entityManager = persistenceSupport.getEntityManager();
		EntityTransaction currentTranslation = entityManager.getTransaction();
		currentTranslation.begin();
		entityManager.merge(entity);
		currentTranslation.commit();
		persistenceSupport.closeEntityManager();
		return true;
	}
	
	public <T extends DbEntity> boolean removeEntity(Class<T> entityClass, Integer id) {
		EntityManager entityManager = persistenceSupport.getEntityManager();
		EntityTransaction currentTranslation = entityManager.getTransaction();
		currentTranslation.begin();
		Query query = entityManager.createQuery("DELETE " + entityClass.getName() + " e where e.id = " + id);
		query.executeUpdate();
		currentTranslation.commit();
		persistenceSupport.closeEntityManager();
		return true;
	}
	
}

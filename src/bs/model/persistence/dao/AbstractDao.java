package bs.model.persistence.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import bs.model.persistence.entities.DbEntity;

public abstract class AbstractDao {

	private PersistenceSupport persistenceSupport;
	
	public AbstractDao() {
		persistenceSupport = new PersistenceSupport();
	}
	
	public void persistEntity(DbEntity entity) {
		EntityManager entityManager = persistenceSupport.getEntityManager();
		EntityTransaction currentTranslation = entityManager.getTransaction();
		currentTranslation.begin();
		entityManager.persist(entity);
		currentTranslation.commit();
		persistenceSupport.closeEntityManager();
	}
	
	public void mergeEntity(DbEntity entity) {
		EntityManager entityManager = persistenceSupport.getEntityManager();
		EntityTransaction currentTranslation = entityManager.getTransaction();
		currentTranslation.begin();
		entityManager.merge(entity);
		currentTranslation.commit();
		persistenceSupport.closeEntityManager();
	}
	
	public <T extends DbEntity> void removeEntity(Class<T> entityClass, Integer id) {
		EntityManager entityManager = persistenceSupport.getEntityManager();
		EntityTransaction currentTranslation = entityManager.getTransaction();
		currentTranslation.begin();
		Query query = entityManager.createQuery("DELETE " + entityClass.getName() + " e where e.id = " + id);
		query.executeUpdate();
		currentTranslation.commit();
	}
	
}

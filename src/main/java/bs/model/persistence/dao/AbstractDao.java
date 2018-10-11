package bs.model.persistence.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import bs.model.persistence.entities.DbEntity;

/**
 * Contains create/update/delete methods for extending DAO classes.
 * @author Mateusz
 * @param <T> Type of entity which DAO class invoke.
 */
public abstract class AbstractDao<T extends DbEntity> {

	private PersistenceSupport persistenceSupport;
	
	public AbstractDao() {
		persistenceSupport = new PersistenceSupport();
	}
	
	/**
	 * @param entity Entity class which has to be inserted.
	 */
	protected T persistEntity(T entity) {
		EntityManager entityManager = persistenceSupport.getEntityManager();
		EntityTransaction currentTranslation = entityManager.getTransaction();
		currentTranslation.begin();
		entity.setId(null);
		entityManager.persist(entity);
		currentTranslation.commit();
		persistenceSupport.closeEntityManager();
		return entity;
	}
	
	/**
	 * @param entity Entity class which has to be updated.
	 */
	protected T mergeEntity(T entity) {
		EntityManager entityManager = persistenceSupport.getEntityManager();
		EntityTransaction currentTranslation = entityManager.getTransaction();
		currentTranslation.begin();
		entityManager.merge(entity);
		currentTranslation.commit();
		persistenceSupport.closeEntityManager();
		return entity;
	}
	
	/**
	 * @param entityClass Deleting entity class.
	 * @param id Database id of entity.
	 */
	protected void removeEntity(Class<T> entityClass, Integer id) {
		EntityManager entityManager = persistenceSupport.getEntityManager();
		EntityTransaction currentTranslation = entityManager.getTransaction();
		currentTranslation.begin();
		Query query = entityManager.createQuery("DELETE " + entityClass.getName() + " e where e.id = " + id);
		query.executeUpdate();
		currentTranslation.commit();
		persistenceSupport.closeEntityManager();
	}

	protected PersistenceSupport getPersistenceSupport() {
		return persistenceSupport;
	}

}

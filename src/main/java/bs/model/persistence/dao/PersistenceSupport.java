package bs.model.persistence.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import bs.model.config.Finals;

/**
 * Support for persistence classes.
 * Generates JPA / Hibernate objects in easy way.
 * @author Mateusz
 */
class PersistenceSupport implements AutoCloseable {
	
	private EntityManagerFactory entityManagerFactory;
	
	private EntityManager entityManager;
	
	public PersistenceSupport() {
		entityManagerFactory = Persistence.createEntityManagerFactory(Finals.PERSISTENCE_UNIT_NAME);
		entityManager = entityManagerFactory.createEntityManager();
	}
	
	/**
	 * Generate EntityManager from project persistence unit configuration.
	 * @return EntityManager object.
	 */
	public synchronized EntityManager getEntityManager() {
		return entityManager;
	}
	
	/**
	 * Should be invoked after EnityManager use !
	 */
	public synchronized void closeEntityManager() {
		entityManager.close();
		entityManagerFactory.close();
	}

	@Override
	public synchronized void close()  {
		closeEntityManager();	
	}
	
}

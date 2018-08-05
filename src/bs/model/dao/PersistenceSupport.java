package bs.model.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import bs.model.config.AppConfig;

public class PersistenceSupport {
	
	private EntityManagerFactory entityManagerFactory;
	
	private EntityManager entityManager;
	
	public PersistenceSupport() {
		entityManagerFactory = Persistence.createEntityManagerFactory(AppConfig.PERSISTENCE_UNIT_NAME);
		entityManager = entityManagerFactory.createEntityManager();
	}
	
	/* Should be closed by method closeEntityManager() */
	public EntityManager getEntityManager() {
		return entityManager;
	}
	
	public void closeEntityManager() {
		entityManager.close();
		entityManagerFactory.close();
	}
	
}
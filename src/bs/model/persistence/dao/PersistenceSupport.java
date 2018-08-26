package bs.model.persistence.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import bs.model.config.Finals;

public class PersistenceSupport implements AutoCloseable {
	
	private EntityManagerFactory entityManagerFactory;
	
	private EntityManager entityManager;
	
	public PersistenceSupport() {
		entityManagerFactory = Persistence.createEntityManagerFactory(Finals.PERSISTENCE_UNIT_NAME);
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

	@Override
	public void close() throws Exception {
		closeEntityManager();	
	}
	
}

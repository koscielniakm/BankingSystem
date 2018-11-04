package bs.model.persistence.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

class PersistenceSupport implements AutoCloseable {
	
	private static final String PERSISTENCE_UNIT_NAME = "BankingSystemPersistence";
	
	private EntityManagerFactory entityManagerFactory;
	
	private EntityManager entityManager;
	
	public PersistenceSupport() {
		entityManagerFactory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
		entityManager = entityManagerFactory.createEntityManager();
	}
	
	@Override
	public synchronized void close() {
		closeEntityManager();	
	}
	
	public synchronized EntityManager getEntityManager() {
		return entityManager;
	}
	
	public synchronized void closeEntityManager() {
		entityManager.close();
		entityManagerFactory.close();
	}
	
}

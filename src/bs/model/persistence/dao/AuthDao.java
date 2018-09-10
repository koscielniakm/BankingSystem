package bs.model.persistence.dao;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import bs.model.persistence.entities.AccountEntity;

public final class AuthDao {
	
	private PersistenceSupport persistenceSupport;
	
	public AuthDao() {
		persistenceSupport = new PersistenceSupport();
	}
	
	public AccountEntity login(String accountNumber, String password) {
		EntityManager entityManager = persistenceSupport.getEntityManager();
		Query query =  entityManager
			.createQuery("FROM AccountEntity a WHERE a.accountNumber = :accountNumber AND a.password = :password")
			.setParameter("accountNumber", accountNumber)
			.setParameter("password", password);
		AccountEntity loggedAccount = new AccountEntity();
		try
		{
			loggedAccount = (AccountEntity) query.getSingleResult();
		}
		catch (NoResultException e)
		{
			loggedAccount = null;
		}
		finally
		{
			persistenceSupport.closeEntityManager();
		}
		return loggedAccount;
	}
	
}

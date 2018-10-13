package bs.model.persistence.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

import bs.model.persistence.entities.AccountEntity;
import bs.model.persistence.validators.AccountValidator;

public class AccountDao extends AbstractDao<AccountEntity> implements Dao<AccountEntity> {

	private AccountValidator validator;
	
	public AccountDao() {
		validator = new AccountValidator();
	}
	
	@Override
	public AccountEntity create(AccountEntity account) {
		if (validator.validateBeforeCreate(account))
			return super.persistEntity(account);
		else
			throw new PersistenceException();
	}

	@Override
	public AccountEntity update(AccountEntity account) {
		if (validator.validateBeforeUpdate(account))
			return super.mergeEntity(account);
		else
			throw new IllegalArgumentException();
	}

	@Override
	public boolean delete(int id) {
		if (!validator.validateBeforeDelete(id)) return false;
		super.removeEntity(AccountEntity.class, id);
		return true;
	}

	@Override
	public AccountEntity getById(int id) {
		EntityManager entityManager = getEntityManager();
		AccountEntity accountById = entityManager.find(AccountEntity.class, id);
		return accountById;
	}

	@Override
	public List<AccountEntity> getAll() {
		EntityManager entityManager = getEntityManager();
		List<AccountEntity> allAccounts = entityManager
			.createQuery("FROM AccountEntity a", AccountEntity.class).getResultList();
		return allAccounts;
	}
	
	public List<AccountEntity> getByAccountNumber(int accountNumber) {
		EntityManager entityManager = getEntityManager();
		List<AccountEntity> accounts = entityManager
			.createQuery("FROM AccountEntity a WHERE a.accountNumber = :accountNumber", AccountEntity.class)
			.setParameter("accountNumber", accountNumber)
			.getResultList();
		return accounts;
	}	
	
	// Login
	public AccountEntity getByAccountNumberAndPassword(String accountNumber, String password) {
		Integer accountNumberInt = Integer.parseInt(accountNumber);
		EntityManager entityManager = getEntityManager();
		Query query =  entityManager
			.createQuery("FROM AccountEntity a WHERE a.accountNumber = :accountNumber AND a.password = :password")
			.setParameter("accountNumber", accountNumberInt)
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
			closeEntityManager();
		}
		return loggedAccount;
	}
	
}

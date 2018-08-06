package bs.model.persistence.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import bs.model.persistence.entities.Account;

public class AccountDao extends AbstractDao<Account> implements Dao<Account> {

	private AccountValidator validator;
	
	public AccountDao() {
		validator = new AccountValidator();
	}
	
	@Override
	public boolean create(Account account) {
		if (!validator.validateBeforeCreate(account)) return false;
		super.persistEntity(account);
		return true;
	}

	@Override
	public boolean update(Account account) {
		if (!validator.validateBeforeUpdate(account)) return false;
		super.mergeEntity(account);
		return true;
	}

	@Override
	public boolean delete(int id) {
		if (!validator.validateBeforeDelete(id)) return false;
		super.removeEntity(Account.class, id);
		return true;
	}

	@Override
	public Account getById(int id) {
		EntityManager entityManager = getPersistenceSupport().getEntityManager();
		Account accountById = entityManager.find(Account.class, id);
		return accountById;
	}

	@Override
	public List<Account> getAll() {
		EntityManager entityManager = getPersistenceSupport().getEntityManager();
		List<Account> allAccounts = entityManager
			.createQuery("FROM Account a", Account.class).getResultList();
		return allAccounts;
	}
	
	public Account login(int accountNumber, String password) {
		EntityManager entityManager = getPersistenceSupport().getEntityManager();
		Query query =  entityManager
			.createQuery("FROM Account a WHERE a.accountNumber = :accountNumber AND a.password = :password")
			.setParameter("accountNumber", accountNumber)
			.setParameter("password", password);
		Account loggedAccount = new Account();
		try {
			loggedAccount = (Account) query.getSingleResult();
		} catch (NoResultException e) {
			loggedAccount = null;
		} finally {
			getPersistenceSupport().closeEntityManager();
		}
		return loggedAccount;
	}
	
	public List<Account> getByAccountNumber(int accountNumber) {
		EntityManager entityManager = getPersistenceSupport().getEntityManager();
		List<Account> accounts = entityManager
			.createQuery("FROM Account a WHERE a.accountNumber = :accountNumber", Account.class)
			.setParameter("accountNumber", accountNumber)
			.getResultList();
		return accounts;
	}	
	
}

package bs.model.persistence.dao;

import java.util.List;

import javax.persistence.EntityManager;

import bs.model.persistence.entities.AccountEntity;
import bs.model.persistence.validators.AccountValidator;

public class AccountEntityDao extends AbstractEntityDao<AccountEntity> implements EntityDao<AccountEntity> {

	private AccountValidator validator;
	
	public AccountEntityDao() {
		validator = new AccountValidator();
	}
	
	@Override
	public boolean create(AccountEntity account) {
		if (!validator.validateBeforeCreate(account)) return false;
		super.persistEntity(account);
		return true;
	}

	@Override
	public boolean update(AccountEntity account) {
		if (!validator.validateBeforeUpdate(account)) return false;
		super.mergeEntity(account);
		return true;
	}

	@Override
	public boolean delete(int id) {
		if (!validator.validateBeforeDelete(id)) return false;
		super.removeEntity(AccountEntity.class, id);
		return true;
	}

	@Override
	public AccountEntity getById(int id) {
		EntityManager entityManager = getPersistenceSupport().getEntityManager();
		AccountEntity accountById = entityManager.find(AccountEntity.class, id);
		return accountById;
	}

	@Override
	public List<AccountEntity> getAll() {
		EntityManager entityManager = getPersistenceSupport().getEntityManager();
		List<AccountEntity> allAccounts = entityManager
			.createQuery("FROM AccountEntity a", AccountEntity.class).getResultList();
		return allAccounts;
	}
	
	public List<AccountEntity> getByAccountNumber(int accountNumber) {
		EntityManager entityManager = getPersistenceSupport().getEntityManager();
		List<AccountEntity> accounts = entityManager
			.createQuery("FROM AccountEntity a WHERE a.accountNumber = :accountNumber", AccountEntity.class)
			.setParameter("accountNumber", accountNumber)
			.getResultList();
		return accounts;
	}	
	
}

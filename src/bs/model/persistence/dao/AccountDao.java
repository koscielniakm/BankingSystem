package bs.model.persistence.dao;

import java.util.List;

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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Account> getAll() {
		// TODO Auto-generated method stub
		return null;
	}
	
}

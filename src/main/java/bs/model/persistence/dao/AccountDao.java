package bs.model.persistence.dao;

import java.util.List;

import bs.model.persistence.entities.AccountEntity;

public interface AccountDao extends Dao<AccountEntity> {
	
	public List<AccountEntity> getByAccountNumber(int number);
	
	public AccountEntity getByAccountNumberAndPassword(String accountNumber, String password);
	
}

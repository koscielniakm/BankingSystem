package bs.model.persistence.dao;

import bs.model.persistence.entities.Account;

public class AccountValidator implements DaoValidator<Account> {

	public boolean validateBeforeCreate(Account account) {
		if (account == null) return false;
		if (validateAccountNumber(account.getAccountNumber()) &&
			validatePassword(account.getPassword()) &&
			validateEmail(account.getEmail()))
			return true;
		else return false;
	}

	@Override
	public boolean validateBeforeUpdate(Account account) {
		if (account == null) return false;
		if (account.getId() > 0 &&
			validateAccountNumber(account.getAccountNumber()) &&
			validatePassword(account.getPassword()) &&
			validateEmail(account.getEmail()))
			return true;
		else return false;
	}

	@Override
	public boolean validateBeforeDelete(Integer id) {
		if (id > 0) return true;
		return false;
	}
	
	private boolean validateAccountNumber(Integer accountNumber) {
		if (accountNumber == null)
			return false;
		if (accountNumber <= 0)
			return false;
		if (accountNumber.toString().length() < AppConfig.DB_ACCOUNT_ACCOUNTNUMBER_LENGTH)
			return false;
		return true;
	}
	
	private boolean validatePassword(String password) {
		if (password == null || password.length() < AppConfig.ACCOUNT_PASSWORD_MIN_LENGTH)
			return false;
		if (password.length() > AppConfig.DB_ACCOUNT_PASSWORD_MAX_LENGTH)
			return false;
		else return true;
	}
	
	private boolean validateEmail(String email) {
		if (email == null || email.length() > AppConfig.DB_ACCOUNT_EMAIL_LENGTH)
			return false;
		// TODO regex
		return true;
	}
	
}

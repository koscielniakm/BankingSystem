package bs.model.persistence.validators;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import bs.model.config.Finals;
import bs.model.persistence.entities.AccountEntity;

public class AccountValidator implements DaoValidator<AccountEntity> {

	public boolean validateBeforeCreate(AccountEntity account) {
		if (account == null) return false;
		if (validateAccountNumber(account.getAccountNumber()) &&
			validatePassword(account.getPassword()) &&
			validateEmail(account.getEmail()))
			return true;
		else return false;
	}

	public boolean validateBeforeUpdate(AccountEntity account) {
		if (account == null) return false;
		if (account.getId() > 0 &&
			validateAccountNumber(account.getAccountNumber()) &&
			validatePassword(account.getPassword()) &&
			validateEmail(account.getEmail()))
			return true;
		else return false;
	}

	public boolean validateBeforeDelete(Integer id) {
		if (id > 0) return true;
		return false;
	}
	
	private boolean validateAccountNumber(Integer accountNumber) {
		if (accountNumber == null)
			return false;
		if (accountNumber <= 0)
			return false;
		if (accountNumber.toString().length() < Finals.DB_ACCOUNT_ACCOUNTNUMBER_LENGTH)
			return false;
		return true;
	}
	
	private boolean validatePassword(String password) {
		if (password == null || password.length() < Finals.ACCOUNT_PASSWORD_MIN_LENGTH)
			return false;
		if (password.length() > Finals.DB_ACCOUNT_PASSWORD_MAX_LENGTH)
			return false;
		else return true;
	}
	
	private boolean validateEmail(String email) {
		if (email == null || email.length() > Finals.DB_ACCOUNT_EMAIL_LENGTH)
			return false;
		Pattern emailRegex = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
		Matcher matcher = emailRegex.matcher(email);
		return matcher.find();
	}
	
}

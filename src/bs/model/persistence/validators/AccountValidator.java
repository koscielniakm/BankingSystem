package bs.model.persistence.validators;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import bs.model.config.Finals;
import bs.model.persistence.entities.AccountEntity;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class AccountValidator extends AbstractValidator implements DaoValidator<AccountEntity> {

	public boolean validateBeforeCreate(AccountEntity account) {
		for (Boolean validation : getValidationsBeforeCreate(account))
			if (!validation) return false;
		return true;
	}
	
	private List<Boolean> getValidationsBeforeCreate(AccountEntity account) {
		List<Boolean> validationList = new ArrayList<>();
		validationList.add(validateNotNull(account.getAccountNumber()));
		validationList.add(validateNotNull(account.getPassword()));
		validationList.add(validateNotNull(account.getEmail()));
		validationList.add(validateNotNull(account.getOpenDate()));
		validationList.add(validateAccountNumberLength(account.getAccountNumber()));
		validationList.add(validateAccountNumberValue(account.getAccountNumber()));
		validationList.add(validateEmailLength(account.getEmail()));
		validationList.add(validateEmailSyntax(account.getEmail()));
		return validationList;
	}
	
	public boolean validateBeforeUpdate(AccountEntity entity) {
		// TODO AccountValidator : validateBeforeUpdate(AccountEntity) impl.
		throw new NotImplementedException();
	}
	
	public boolean validateBeforeDelete(Integer id) {
		// TODO AccountValidator : validateBeforeDelete(AccountEntity) impl.
		throw new NotImplementedException();
	}
	
	private boolean validateId(Integer id) {
		return id == null || id < 0 ? false : true;
	}
	
	private boolean validateAccountNumberValue(Integer accountNumber) {
		Integer minValue = Finals.DB_ACCOUNT_ACCOUNTNUMBER_MIN_VALUE;
		Integer maxValue = Finals.DB_ACCOUNT_ACCOUNTNUMBER_MAX_VALUE;
		return accountNumber < minValue && accountNumber > maxValue ? true : false;
	}
	
	private boolean validateAccountNumberLength(Integer accountNumber) {
		if (accountNumber.toString().length() == Finals.DB_ACCOUNT_ACCOUNTNUMBER_LENGTH)
			return true;
		else
			return false;
	}
	
	private boolean validateEmailLength(String email) {
		Integer maxLength = Finals.DB_ACCOUNT_EMAIL_LENGTH;
		return email.length() > maxLength ? false : true;
	}
	
	private boolean validateEmailSyntax(String email) {
		Pattern emailRegex = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
		Matcher matcher = emailRegex.matcher(email);
		return matcher.find();
	}
	
}

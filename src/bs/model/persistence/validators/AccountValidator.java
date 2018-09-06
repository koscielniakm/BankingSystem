package bs.model.persistence.validators;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import bs.model.config.Finals;
import bs.model.persistence.entities.AccountEntity;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

/**
 * Validator for AccountEntity class.
 * @author Mateusz
 */
public class AccountValidator extends AbstractValidator implements DaoValidator<AccountEntity> {

	/**
	 * Validate AccountEntity before database insertion.
	 * @param account AccountEntity.
	 * @return Result of validation process.
	 */
	public boolean validateBeforeCreate(AccountEntity account) {
		for (Boolean validation : getValidationsBeforeCreate(account))
			if (!validation) return false;
		return true;
	}
	
	/**
	 * Execute needed validation before database insert and return results.
	 * @param account AccountEntity.
	 * @return List of validations result.
	 */
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
	
	/**
	 * Execute needed validation before database update and return results.
	 * @param account AccountEntity.
	 * @return List of validations result.
	 */
	public boolean validateBeforeUpdate(AccountEntity entity) {
		// TODO AccountValidator : validateBeforeUpdate(AccountEntity) impl.
		throw new NotImplementedException();
	}
	
	/**
	 * Execute needed validation before database delete and return results.
	 * @param id Id of AccountEntity.
	 * @return Validation result.
	 */
	public boolean validateBeforeDelete(Integer id) {
		// TODO AccountValidator : validateBeforeDelete(AccountEntity) impl.
		throw new NotImplementedException();
	}
	
	/**
	 * Check range value of account number.
	 * @param accountNumber Number of account.
	 * @return Validation result.
	 */
	private boolean validateAccountNumberValue(Integer accountNumber) {
		Integer minValue = Finals.DB_ACCOUNT_ACCOUNTNUMBER_MIN_VALUE;
		Integer maxValue = Finals.DB_ACCOUNT_ACCOUNTNUMBER_MAX_VALUE;
		return accountNumber < minValue && accountNumber > maxValue ? true : false;
	}
	
	/**
	 * Check length of account number.
	 * @param accountNumber Number of account.
	 * @return Validation result.
	 */
	private boolean validateAccountNumberLength(Integer accountNumber) {
		Integer length = Finals.DB_ACCOUNT_ACCOUNTNUMBER_LENGTH;
		return accountNumber.toString().length() > length ? false : true;
	}
	
	/**
	 * Check email length.
	 * @param email Some email.
	 * @return Validation result.
	 */
	private boolean validateEmailLength(String email) {
		Integer maxLength = Finals.DB_ACCOUNT_EMAIL_LENGTH;
		return email.length() > maxLength ? false : true;
	}
	
	/**
	 * Check syntax of email by regex.
	 * @param email Some email.
	 * @return Validation result.
	 */
	private boolean validateEmailSyntax(String email) {
		Pattern emailRegex = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
		Matcher matcher = emailRegex.matcher(email);
		return matcher.find();
	}
	
}

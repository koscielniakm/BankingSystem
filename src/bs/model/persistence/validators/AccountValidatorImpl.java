package bs.model.persistence.validators;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import bs.model.config.Finals;
import bs.model.persistence.entities.AccountEntity;

/**
 * Validator for AccountEntity class.
 * @author Mateusz
 */
public class AccountValidatorImpl extends AbstractValidator implements DaoValidator<AccountEntity> {

	/**
	 * Validate AccountEntity before database insertion.
	 * @param account AccountEntity.
	 * @return Result of validation process.
	 */
	@Override
	public boolean validateBeforeCreate(AccountEntity account) {
		return getValidationResult(getValidationsBeforeCreate(account));
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
		validationList.add(validateNotNull(account.getOwnerFirstName()));
		validationList.add(validateNotNull(account.getOwnerLastName()));
		validationList.add(validateAccountNumberLength(account.getAccountNumber()));
		validationList.add(validateAccountNumberValue(account.getAccountNumber()));
		validationList.add(validateEmailLength(account.getEmail()));
		validationList.add(validateEmailSyntax(account.getEmail()));
		validationList.add(validateOwnerFirstNameLength(account.getOwnerFirstName()));
		validationList.add(validateOwnerLastNameLength(account.getOwnerLastName()));
		return validationList;
	}
	
	/**
	 * Execute needed validation before database update and return results.
	 * @param account AccountEntity.
	 * @return List of validations result.
	 */
	@Override
	public boolean validateBeforeUpdate(AccountEntity account) {
		return getValidationResult(getValidationsBeforeUpdate(account));
	}
	
	/**
	 * Execute needed validation before database update and return results.
	 * @param account AccountEntity.
	 * @return List of validations result.
	 */
	private List<Boolean> getValidationsBeforeUpdate(AccountEntity account) {
		List<Boolean> validationList = new ArrayList<>();
		validationList.add(validateNotNull(account.getId()));
		validationList.add(validateNotNull(account.getAccountNumber()));
		validationList.add(validateNotNull(account.getEmail()));
		validationList.add(validateNotNull(account.getOpenDate()));
		validationList.add(validateNotNull(account.getOwnerFirstName()));
		validationList.add(validateNotNull(account.getOwnerLastName()));
		validationList.add(validateId(account.getId()));
		validationList.add(validateAccountNumberLength(account.getAccountNumber()));
		validationList.add(validateAccountNumberValue(account.getAccountNumber()));
		validationList.add(validateEmailLength(account.getEmail()));
		validationList.add(validateEmailSyntax(account.getEmail()));
		validationList.add(validateOwnerFirstNameLength(account.getOwnerFirstName()));
		validationList.add(validateOwnerLastNameLength(account.getOwnerLastName()));
		return validationList;
	}
	
	/**
	 * Execute needed validation before database delete and return results.
	 * @param id Id of AccountEntity.
	 * @return Validation result.
	 */
	@Override
	public boolean validateBeforeDelete(Integer id) {
		return validateId(id);
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
	
	/**
	 * Check owner first name length.
	 * @param firstName First name of account owner.
	 * @return Validation result.
	 */
	private boolean validateOwnerFirstNameLength(String firstName) {
		Integer maxLength = Finals.DB_ACCOUNT_FIRSTNAME_MAX_LENGTH;
		return firstName.length() > maxLength ? false : true;
	}
	
	/**
	 * Check owner last name length.
	 * @param lastName Last name of account owner.
	 * @return Validation result.
	 */
	private boolean validateOwnerLastNameLength(String lastName) {
		Integer maxLength = Finals.DB_ACCOUNT_LASTNAME_MAX_LENGTH;
		return lastName.length() > maxLength ? false : true;
	}
	
}

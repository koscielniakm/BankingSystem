package bs.model.services.registration;

import java.util.Date;

import javax.persistence.NoResultException;
import javax.persistence.PersistenceException;

import bs.model.persistence.dao.AccountDao;
import bs.model.persistence.entities.AccountEntity;
import bs.model.services.crypto.Hasher;

/**
 * Service used to register new account. 
 * @author Mateusz
 */
public class RegistrationService {

	private AccountDao accountDao;
	
	private AccountNumberGenerator numberGenerator;
	
	private AccountEntity registeredAccount;
	
	private RegistrationStatus status;
	
	public RegistrationService(AccountDao accountDao, AccountNumberGenerator numberGenerator) {
		this.accountDao = accountDao;
		this.numberGenerator = numberGenerator;
		status = RegistrationStatus.PENDING;
	}
	
	/**
	 * Begin registration process.
	 * @param password New account password (not hashed)
	 * @param email Email for new account
	 * @return Result of register.
	 */
	public boolean register(String password, String email) {
		AccountEntity generatedAccount = generateAccount(password, email);
		try
		{
			generatedAccount = accountDao.create(generatedAccount);
		}
		catch (PersistenceException e)
		{
			return doRegisterFailed();
		}
		return doRegisterSuccess(generatedAccount);
	}
	
	/**
	 * Set registration success.
	 * @param account Generated account.
	 * @return true Always true.
	 */
	private boolean doRegisterSuccess(AccountEntity account) {
		registeredAccount = account;
		status = RegistrationStatus.SUCCESS;
		return true;
	}
	
	/**
	 * Set registration failed.
	 * @return true Always false.
	 */
	private boolean doRegisterFailed() {
		status = RegistrationStatus.FAILED;
		return false;
	}
	
	/**
	 * Generate new account data.
	 * @param password Not hashed account password.
	 * @param email Account email.
	 * @return Generated account.
	 */
	private AccountEntity generateAccount(String password, String email) {
		AccountEntity generatedAccount = new AccountEntity();
		generatedAccount.setAccountNumber(numberGenerator.generateAccountNumber(accountDao));
		generatedAccount.setPassword(Hasher.hashPassword(password));
		generatedAccount.setEmail(email);
		generatedAccount.setOpenDate(new Date());
		return generatedAccount;
	}
	
	/**
	 * @throws NoResultException if registration failed.
	 * @return Registered account.
	 */
	public AccountEntity getRegisteredAccount() throws NoResultException {
		if (registeredAccount == null) throw new NoResultException();
		else return registeredAccount;
	}
	
	/**
	 * Get status of current registration process.
	 * @return Status of registration.
	 */
	public RegistrationStatus getStatus() {
		return status;
	}
	
}

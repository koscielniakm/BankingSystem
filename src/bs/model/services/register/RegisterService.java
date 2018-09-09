package bs.model.services.register;

import java.util.Date;

import javax.persistence.NoResultException;

import bs.model.persistence.dao.AccountDao;
import bs.model.persistence.entities.AccountEntity;
import bs.model.services.security.Hasher;

/**
 * Service used to register new account. 
 * @author Mateusz
 */
public class RegisterService {

	private AccountDao accountDao;
	
	private AccountNumberGenerator numberGenerator;
	
	private AccountEntity registeredAccount;
	
	private RegisterStatus status;
	
	public RegisterService() {
		accountDao = new AccountDao();
		numberGenerator = new AccountNumberGenerator();
		status = RegisterStatus.PENDING;
	}
	
	/**
	 * Begin registration process.
	 * @param password New account password (not hashed)
	 * @param email Email for new account
	 * @return Result of register.
	 */
	public boolean register(String password, String email) {
		AccountEntity generatedAccount = generateAccount(password, email);
		return accountDao.create(generatedAccount) ? doRegisterSuccess(generatedAccount) : doRegisterFailed();
	}
	
	/**
	 * Set register success.
	 * @param account Generated account.
	 * @return true Always true.
	 */
	private boolean doRegisterSuccess(AccountEntity account) {
		registeredAccount = account;
		status = RegisterStatus.SUCCESS;
		return true;
	}
	
	/**
	 * Set register failed.
	 * @return true Always false.
	 */
	private boolean doRegisterFailed() {
		status = RegisterStatus.FAILED;
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
	public RegisterStatus getStatus() {
		return status;
	}
	
}

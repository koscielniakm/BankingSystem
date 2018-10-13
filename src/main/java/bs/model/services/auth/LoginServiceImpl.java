package bs.model.services.auth;

import javax.persistence.NoResultException;

import bs.model.persistence.dao.AccountDao;
import bs.model.persistence.entities.AccountEntity;
import bs.model.services.crypto.Hasher;

/**
 * Class used to login user into application. 
 * @author Mateusz
 */
public class LoginServiceImpl implements LoginService {
	
	private String accountNumber;
	
	private String password;
	
	private AccountEntity loggedAccount;
	
	private AccountDao accountDao;
	
	private LoginStatus status;
	
	/**
	 * @param accountNumber Number of account which user want to log in.
	 * @param password Password (not hashed) entered by user.
	 */
	public LoginServiceImpl(String accountNumber, String password) {
		this.accountNumber = accountNumber;
		this.password = Hasher.hashPassword(password);
		this.accountDao = new AccountDao();
		this.status = LoginStatus.PENDING;
	}
	
	/**
	 * @return Logged account.
	 */
	public AccountEntity getLoggedAccount() throws NoResultException {
		if (loggedAccount == null)
			throw new NoResultException();
		return loggedAccount;
	}
	
	/**
	 * @return Input account number.
	 */
	public String getAccountNumber() {
		return accountNumber;
	}
	
	/**
	 * @return Status of current login.
	 */
	public LoginStatus getStatus() {
		return status;
	}
	
	/**
	 * @return Result of login try.
	 */
	public boolean login() {
		loggedAccount = accountDao.getByAccountNumberAndPassword(accountNumber, password);
		return loggedAccount != null ? doLoginSuccess() : doLoginFailed();
	}
	
	/**
	 * Set login success.
	 * @return Always true.
	 */
	private boolean doLoginSuccess() {
		status = LoginStatus.SUCCESS;
		return true;
	}
	
	/**
	 * Set login failed.
	 * @return Always false.
	 */
	private boolean doLoginFailed() {
		status = LoginStatus.FAILED;
		return false;
	}
	
}

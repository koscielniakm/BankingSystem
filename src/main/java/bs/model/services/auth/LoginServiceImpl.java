package bs.model.services.auth;

import javax.persistence.NoResultException;

import bs.model.persistence.dao.AccountDao;
import bs.model.persistence.entities.AccountEntity;

/**
 * Class used to login user into application. 
 * @author Mateusz
 */
public class LoginServiceImpl implements LoginService {
	
	private UserAuthData userAuthData;
	
	private AccountDao accountDao;
	
	private LoginStatus status;
	
	private AccountEntity loggedAccount;
	
	/**
	 * @param userAuthData Data of user: account number and password (not hashed).
	 * @param accountDao Instance of AccountDao.
	 */
	public LoginServiceImpl(UserAuthData userAuthData, AccountDao accountDao) {
		this.userAuthData = userAuthData;
		this.accountDao = accountDao;
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
		return userAuthData.getAccountNumber();
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
		String accountNumber = userAuthData.getAccountNumber();
		String password = userAuthData.getPassword();
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

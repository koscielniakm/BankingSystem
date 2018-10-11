package bs.model.services.auth;

import java.util.Date;

import javax.persistence.NoResultException;

import bs.model.persistence.dao.AccountEntityDao;
import bs.model.persistence.dao.LoginEntityDao;
import bs.model.persistence.entities.AccountEntity;
import bs.model.persistence.entities.LoginEntity;
import bs.model.services.security.Hasher;
import bs.model.services.security.IpGetter;

/**
 * Class used to login user into application. 
 * @author Mateusz
 */
public class LoginService {
	
	private String input;
	
	private String password;
	
	private AccountEntity loggedAccount;
	
	private AccountEntityDao accountDao;
	
	private LoginEntityDao loginDao;
	
	private LoginStatus status;
	
	/**
	 * @param accountNumber Number of account which user want to log in.
	 * @param password Password (not hashed) entered by user.
	 */
	public LoginService(String input, String password) {
		this.input = input;
		this.password = Hasher.hashPassword(password);
		this.accountDao = new AccountEntityDao();
		this.loginDao = new LoginEntityDao();
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
	 * @return Status of current login.
	 */
	public LoginStatus getStatus() {
		return status;
	}
	
	/**
	 * @return Result of login try.
	 */
	public boolean login() {
		loggedAccount = accountDao.getByAccountNumberAndPassword(input, password);
		return loggedAccount != null ? doLoginSuccess() : doLoginFailed();
	}
	
	/**
	 * Set login success.
	 * @return Always true.
	 */
	private boolean doLoginSuccess() {
		status = LoginStatus.SUCCESS;
		insertLoginTryToDatabase(status);
		return true;
	}
	
	/**
	 * Set login failed.
	 * @return Always false.
	 */
	private boolean doLoginFailed() {
		insertLoginTryToDatabase(status);
		status = LoginStatus.FAILED;
		return false;
	}
	
	/**
	 * Register current login try in database.
	 * @param status Status of current authorization process.
	 */
	private void insertLoginTryToDatabase(LoginStatus status) {
		LoginEntity currentLogin = generateCurrentLoginEntity(status);
		loginDao.create(currentLogin);
	}
	
	/**
	 * @param status Current LoginStatus
	 * @return Generated LoginEntity of current login ready to insert to database.
	 */
	private LoginEntity generateCurrentLoginEntity(LoginStatus status) {
		if (status == LoginStatus.PENDING) throw new IllegalArgumentException();
		LoginEntity currentLogin = new LoginEntity();
		currentLogin.setInput(setCurrentLoginEntityInput(status));
		currentLogin.setIp(IpGetter.getIp());
		currentLogin.setDate(new Date());
		currentLogin.setSuccess(setCurrentLoginEntitySuccess(status));
		return currentLogin;
	}
	
	
	private String setCurrentLoginEntityInput(LoginStatus status) {
		return status == LoginStatus.SUCCESS ? input : null;
	}
	
	private boolean setCurrentLoginEntitySuccess(LoginStatus status) {
		return status == LoginStatus.SUCCESS ? true : false;
	}
	
}

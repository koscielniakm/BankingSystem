package bs.model.services.auth;

import java.util.Date;

import bs.model.persistence.dao.AccountDao;
import bs.model.persistence.dao.LoginDao;
import bs.model.persistence.entities.AccountEntity;
import bs.model.persistence.entities.LoginEntity;
import bs.model.services.security.IpGetter;
import bs.model.services.security.PasswordHasher;

/**
 * Class used to login user into application. 
 */
public class LoginService {
	
	private Integer accountNumber;
	
	private String password;
	
	private AccountEntity loggedAccount;
	
	private AccountDao accountDao;
	
	private LoginDao loginDao;
	
	private LoginStatus status;
	
	/**
	 * @param accountNumber Number of account which user want to log in.
	 * @param password Password (not hashed) entered by user.
	 */
	public LoginService(int accountNumber, String password) {
		this.accountNumber = accountNumber;
		this.password = PasswordHasher.hashPassword(password);
		this.accountDao = new AccountDao();
		this.loginDao = new LoginDao();
		this.status = LoginStatus.PENDING;
	}
	
	/**
	 * @return Result of login try.
	 */
	public boolean login() {
		loggedAccount = accountDao.login(accountNumber, password);
		if (loggedAccount != null) {
			status = LoginStatus.SUCCESS;
			insertLoginTryToDatabase(status);
			return true;
		} else {
			insertLoginTryToDatabase(status);
			status = LoginStatus.FAILED;
			return false;
		}
	}
	
	/**
	 * @return Logged account.
	 */
	public AccountEntity getLoggedAccount() {
		return loggedAccount;
	}
	
	/**
	 * @return Status of current login.
	 */
	public LoginStatus getStatus() {
		return status;
	}
	
	private void insertLoginTryToDatabase(LoginStatus status) {
		LoginEntity currentLogin = generateCurrentLoginEntity(status);
		loginDao.create(currentLogin);
	}
	
	private LoginEntity generateCurrentLoginEntity(LoginStatus status) {
		if (status == LoginStatus.PENDING) throw new IllegalArgumentException();
		LoginEntity currentLogin = new LoginEntity();
		if (status == LoginStatus.SUCCESS)
			currentLogin.setIdAccount(accountNumber);
		else
			currentLogin.setIdAccount(null);
		currentLogin.setIp(IpGetter.getIp());
		currentLogin.setDate(new Date());
		if (status == LoginStatus.SUCCESS)
			currentLogin.setSuccess(true);
		else
			currentLogin.setSuccess(false);
		return currentLogin;
	}
	
}

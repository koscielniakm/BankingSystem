package bs.model.services.auth;

import java.util.Date;

import bs.model.persistence.dao.AccountDao;
import bs.model.persistence.dao.LoginDao;
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
	
	private AccountDao accountDao;
	
	private LoginDao loginDao;
	
	private LoginStatus status;
	
	/**
	 * @param accountNumber Number of account which user want to log in.
	 * @param password Password (not hashed) entered by user.
	 */
	public LoginService(String input, String password) {
		this.input = input;
		this.password = Hasher.hashPassword(password);
		this.accountDao = new AccountDao();
		this.loginDao = new LoginDao();
		this.status = LoginStatus.PENDING;
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
	
	/**
	 * @return Result of login try.
	 */
	public boolean login() {
		loggedAccount = accountDao.login(input, password);
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

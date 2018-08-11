package bs.model.services.auth;

import java.util.Date;

import bs.model.persistence.dao.AccountDao;
import bs.model.persistence.dao.LoginDao;
import bs.model.persistence.entities.AccountEntity;
import bs.model.persistence.entities.LoginEntity;
import bs.model.services.security.IpGetter;
import bs.model.services.security.PasswordHasher;

public class LoginService {
	
	private Integer accountNumber;
	
	private String password;
	
	private AccountEntity loggedAccount;
	
	private AccountDao accountDao;
	
	private LoginDao loginDao;
	
	private LoginStatus status;
	
	public LoginService(int accountNumber, String password) {
		this.accountNumber = accountNumber;
		this.password = PasswordHasher.hashPassword(password);
		this.accountDao = new AccountDao();
		this.loginDao = new LoginDao();
		this.status = LoginStatus.PENDING;
	}
	
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
	
	public AccountEntity getLoggedAccount() {
		return loggedAccount;
	}
	
	public LoginStatus getStatus() {
		return status;
	}
	
	private void insertLoginTryToDatabase(LoginStatus status) {
		LoginEntity currentLogin = generateCurrentLoginEntity(status);
		loginDao.create(currentLogin);
	}
	
	private LoginEntity generateCurrentLoginEntity(LoginStatus status) {
		LoginEntity currentLogin = new LoginEntity();
		currentLogin.setIdAccount(accountNumber);
		currentLogin.setIp(IpGetter.getIp());
		currentLogin.setDate(new Date());
		if (status == LoginStatus.SUCCESS)
			currentLogin.setSuccess(true);
		else if (status == LoginStatus.FAILED)
			currentLogin.setSuccess(false);
		return currentLogin;
	}
	
}

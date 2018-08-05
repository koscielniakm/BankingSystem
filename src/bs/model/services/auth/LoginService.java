package bs.model.services.auth;

import bs.model.persistence.dao.AccountDao;
import bs.model.persistence.entities.Account;

public class LoginService {
	
	private Integer accountNumber;
	
	private String password;
	
	private Account loggedAccount;
	
	private AccountDao accountDao;
	
	private LoginStatus status;
	
	public LoginService(int accountNumber, String password) {
		this.accountNumber = accountNumber;
		this.password = password;
		this.accountDao = new AccountDao();
		this.status = LoginStatus.PENDING;
	}
	
	public boolean login() {
		loggedAccount = accountDao.login(accountNumber, password);
		if (loggedAccount != null) {
			status = LoginStatus.SUCCESS;
			return true;
		} else {
			status = LoginStatus.FAILED;
			return false;
		}
	}
	
	public Account getLoggedAccount() {
		return loggedAccount;
	}
	
	public LoginStatus getStatus() {
		return status;
	}
	
}

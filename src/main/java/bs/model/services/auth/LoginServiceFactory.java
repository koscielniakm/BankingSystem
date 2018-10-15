package bs.model.services.auth;

import bs.model.persistence.dao.AccountDao;

public class LoginServiceFactory{

	private LoginServiceFactory() { }
	
	public static LoginService getLoginService(String accountNumber, String password) {
		UserAuthData userAuthData = new UserAuthData(accountNumber, password);
		return new LoginServiceImpl(userAuthData, new AccountDao());
	}

}

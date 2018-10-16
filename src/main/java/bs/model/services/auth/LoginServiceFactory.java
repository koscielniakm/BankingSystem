package bs.model.services.auth;

import bs.model.persistence.dao.DaoFactory;

public class LoginServiceFactory{

	private LoginServiceFactory() { }
	
	public static LoginService getLoginService(String accountNumber, String password) {
		return new LoginServiceImpl(new UserAuthData(accountNumber, password), DaoFactory.getAccountDao());
	}

}

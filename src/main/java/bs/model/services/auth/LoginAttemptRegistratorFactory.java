package bs.model.services.auth;

import bs.model.persistence.dao.DaoFactory;

public class LoginAttemptRegistratorFactory {

	private LoginAttemptRegistratorFactory() { }
	
	public static LoginAttemptRegistrator getLoginAttemptRegistrator(LoginService service) {
		return new LoginAttemptRegistratorImpl(service, DaoFactory.getLoginDao());
	}

}

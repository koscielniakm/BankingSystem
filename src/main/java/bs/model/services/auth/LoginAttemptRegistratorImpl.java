package bs.model.services.auth;

import java.util.Date;

import javax.persistence.PersistenceException;

import bs.model.persistence.dao.LoginDaoImpl;
import bs.model.persistence.entities.LoginEntity;
import bs.model.services.crypto.IpGetter;

public class LoginAttemptRegistratorImpl implements LoginAttemptRegistrator {

	private LoginService service;
	
	private LoginDaoImpl dao;
	
	public LoginAttemptRegistratorImpl(LoginService service, LoginDaoImpl dao) {
		this.service = service;
		this.dao = dao;
	}
	
	public boolean registerLoginAttempt() {
		try
		{
			LoginEntity currentLogin = prepareCurrentLoginEntity();
			dao.create(currentLogin);
		}
		catch (PersistenceException e)
		{
			return false;
		}
		return true;
	}
	
	private LoginEntity prepareCurrentLoginEntity() {
		if (service.getStatus() == LoginStatus.PENDING)
			throw new IllegalArgumentException();
		LoginEntity currentLogin = new LoginEntity();
		currentLogin.setInput(service.getAccountNumber());
		currentLogin.setIp(IpGetter.getIp());
		currentLogin.setDate(new Date());
		currentLogin.setSuccess(setCurrentLoginEntitySuccess(service.getStatus()));
		return currentLogin;
	}
	
	private boolean setCurrentLoginEntitySuccess(LoginStatus status) {
		return status == LoginStatus.SUCCESS ? true : false;
	}
	
}

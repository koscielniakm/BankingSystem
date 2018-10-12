package bs.model.services.auth;

import bs.model.persistence.entities.AccountEntity;

/**
 * Main auth service.
 * @author Mateusz
 */
public interface LoginService {

	/**
	 * Execute login process.
	 * @return 
	 */
	public boolean login();
	
	/**
	 * @return Logged account
	 */
	public AccountEntity getLoggedAccount();
	
	/**
	 * @return Status of current login process.
	 */
	public LoginStatus getStatus();
	
}

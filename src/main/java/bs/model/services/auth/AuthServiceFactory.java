package bs.model.services.auth;

public interface AuthServiceFactory {
	
	/**
	 * @return Produced LoginService.
	 */
	LoginService getLoginService();
	
}

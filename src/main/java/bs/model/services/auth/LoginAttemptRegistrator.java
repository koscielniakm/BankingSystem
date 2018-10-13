package bs.model.services.auth;

public interface LoginAttemptRegistrator {
	
	/**
	 * This method should execute registration of login attempt.
	 * @return Result.
	 */
	public boolean registerLoginAttempt();
	
}

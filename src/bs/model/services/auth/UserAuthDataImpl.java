package bs.model.services.auth;

/**
 * Class should contain necessary data to token validation.
 * Instace of this class is sending to TokenEncoder / TokenDecoder classes.
 * @author Mateusz
 */
public class UserAuthDataImpl implements UserAuthData {
	
	private Integer userId;
	
	public UserAuthDataImpl(Integer userId) {
		this.userId = userId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	
}

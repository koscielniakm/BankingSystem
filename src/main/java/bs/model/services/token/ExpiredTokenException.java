package bs.model.services.token;

public class ExpiredTokenException extends IllegalArgumentException {
	
	private static final long serialVersionUID = -1236878487019916107L;

	public ExpiredTokenException(String message) {
		super(message);
	}
	
}

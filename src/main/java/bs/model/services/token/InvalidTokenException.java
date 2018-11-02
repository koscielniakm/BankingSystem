package bs.model.services.token;

public class InvalidTokenException extends IllegalArgumentException {

	private static final long serialVersionUID = -298737002896241245L;

	public InvalidTokenException(String message) {
		super(message);
	}

}

package bs.controller.support;

/**
 * Property is pair (key, value) used to building Http Response based on JSON.
 * @author Mateusz
 */
public final class Property {

	private String key;
	
	private String value;
	
	public Property(String key, String value) {
		this.key = key;
		this.value = value;
	}

	public String getKey() {
		return key;
	}

	public String getValue() {
		return value;
	}

}

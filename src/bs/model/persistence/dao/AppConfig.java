package bs.model.persistence.dao;

public class AppConfig {
	
	public static final String PERSISTENCE_UNIT_NAME = "BankingSystemPersistence";
	
	// Database
	public static final int DB_ACCOUNT_ACCOUNTNUMBER_LENGTH = 12;
	public static final int DB_ACCOUNT_PASSWORD_MAX_LENGTH = 50;
	public static final int DB_ACCOUNT_EMAIL_LENGTH = 50;
	// Application
	public static final int ACCOUNT_PASSWORD_MIN_LENGTH = 8;
	
}

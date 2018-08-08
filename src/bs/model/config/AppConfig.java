package bs.model.config;

public class AppConfig {
	
	public static final String PERSISTENCE_UNIT_NAME = "BankingSystemPersistence";
	
	// Database
	public static final int DB_ACCOUNT_ACCOUNTNUMBER_LENGTH = 9;
	public static final int DB_ACCOUNT_ACCOUNTNUMBER_MIN_VALUE = 100000000;
	public static final int DB_ACCOUNT_ACCOUNTNUMBER_MAX_VALUE = 999999999;
	public static final int DB_ACCOUNT_PASSWORD_MAX_LENGTH = 64;
	public static final int DB_ACCOUNT_EMAIL_LENGTH = 50;
	
	public static final int DB_LOGIN_IP_LENGTH = 16;
	
	// Application
	public static final int ACCOUNT_PASSWORD_MIN_LENGTH = 8;
	
}

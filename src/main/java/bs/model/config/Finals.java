package bs.model.config;

import io.jsonwebtoken.SignatureAlgorithm;

public class Finals {
	
	// Persistence
	public static final String PERSISTENCE_UNIT_NAME = "BankingSystemPersistence";
	
	// Web config
	public static final String JWT_SECRET_PATH = "app-config.xml";
	public static final Long JWT_EXPIRANTION_MILIS = 86400000L; // 1 day
	public static final SignatureAlgorithm JWT_SIGNATURE_ALGORITHM = SignatureAlgorithm.HS256;
	public static final String JTW_HEADER_NAME = "Token";
	
	// Database
	public static final int DB_ACCOUNT_ACCOUNTNUMBER_LENGTH = 9;
	public static final int DB_ACCOUNT_ACCOUNTNUMBER_MIN_VALUE = 100000000;
	public static final int DB_ACCOUNT_ACCOUNTNUMBER_MAX_VALUE = 999999999;
	public static final int DB_ACCOUNT_PASSWORD_MAX_LENGTH = 64;
	public static final int DB_ACCOUNT_EMAIL_LENGTH = 50;
	public static final int DB_ACCOUNT_FIRSTNAME_MAX_LENGTH = 30;
	public static final int DB_ACCOUNT_LASTNAME_MAX_LENGTH = 30;
	
	public static final int DB_LOGIN_IP_LENGTH = 16;
	
	public static final int DB_NEWS_TITLE_MAX_LENGTH = 50;
	
	public static final int DB_PERSON_FIRSTNAME_MAX_LENGTH = 30;
	public static final int DB_PERSON_LASTNAME_MAX_LENGTH = 30;
	
	// Application
	public static final int ACCOUNT_PASSWORD_MIN_LENGTH = 8;
	
}

package bs.model.services.auth;

import java.util.Random;

import bs.model.config.AppConfig;
import bs.model.persistence.dao.AccountDao;

public class AccountNumberGenerator {

	private static final int VALUE_MIN = AppConfig.DB_ACCOUNT_ACCOUNTNUMBER_MIN_VALUE;
	private static final int VALUE_MAX = AppConfig.DB_ACCOUNT_ACCOUNTNUMBER_MAX_VALUE;
	
	public static int generateAccountNumber(AccountDao dao) {
		Random random = new Random();
		int generatedNumber = 0;
		do {
			generatedNumber = random.nextInt(VALUE_MAX) + VALUE_MIN;
		} while (dao.getByAccountNumber(generatedNumber).size() != 0);
		return generatedNumber;
	}
	
}

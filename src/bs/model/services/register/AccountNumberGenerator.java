package bs.model.services.register;

import java.util.Random;

import bs.model.config.Finals;
import bs.model.persistence.dao.AccountDao;

public class AccountNumberGenerator {

	private static final int VALUE_MIN = Finals.DB_ACCOUNT_ACCOUNTNUMBER_MIN_VALUE;
	private static final int VALUE_MAX = Finals.DB_ACCOUNT_ACCOUNTNUMBER_MAX_VALUE;
	
	public int generateAccountNumber(AccountDao dao) {
		Random random = new Random();
		int generatedNumber = 0;
		do {
			generatedNumber = random.nextInt(VALUE_MAX) + VALUE_MIN;
		} while (dao.getByAccountNumber(generatedNumber).size() != 0);
		return generatedNumber;
	}
	
}

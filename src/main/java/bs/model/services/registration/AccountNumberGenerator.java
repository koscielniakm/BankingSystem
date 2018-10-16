package bs.model.services.registration;

import java.util.Random;

import bs.model.config.Finals;
import bs.model.persistence.dao.AccountDao;

/**
 * Class used to generate number of new account before registration.
 * @author Mateusz
 */
public class AccountNumberGenerator {

	private static final int VALUE_MIN = Finals.DB_ACCOUNT_ACCOUNTNUMBER_MIN_VALUE;
	private static final int VALUE_MAX = Finals.DB_ACCOUNT_ACCOUNTNUMBER_MAX_VALUE;
	
	/**
	 * Generate avaiable account number.
	 * @param dao Instance of AccountDao needed to check
	 * existence of random generated number in database.
	 * @return Avaiable account number.
	 */
	public int generateAccountNumber(AccountDao dao) {
		Random random = new Random();
		int generatedNumber = 0;
		do generatedNumber = random.nextInt(VALUE_MAX) + VALUE_MIN;
		while (dao.getByAccountNumber(generatedNumber).size() != 0);
		return generatedNumber;
	}
	
}

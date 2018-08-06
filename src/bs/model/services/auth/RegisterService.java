package bs.model.services.auth;

import java.util.Date;

import bs.model.persistence.dao.AccountDao;
import bs.model.persistence.entities.Account;

public class RegisterService {

	private AccountDao accountDao;
	
	private AccountNumberGenerator numberGenerator;
	
	private RegisterStatus status;
	
	public RegisterService() {
		accountDao = new AccountDao();
		numberGenerator = new AccountNumberGenerator();
		status = RegisterStatus.PENDING;
	}
	
	public boolean register(String password, String email) {
		Account generatedAccount = generateAccount(password, email);
		if (accountDao.create(generatedAccount)) {
			status = RegisterStatus.SUCCESS;
			return true;
		} else {
			status = RegisterStatus.SUCCESS;
			return false;
		}
	}
	
	private Account generateAccount(String password, String email) {
		Account generatedAccount = new Account();
		generatedAccount.setIdPerson(null);
		generatedAccount.setAccountNumber(numberGenerator.generateAccountNumber(accountDao));
		generatedAccount.setPassword(PasswordHasher.hashPassword(password));
		generatedAccount.setEmail(email);
		generatedAccount.setOpenDate(new Date());
		return generatedAccount;
	}
	
	public RegisterStatus getStatus() {
		return status;
	}
	
}

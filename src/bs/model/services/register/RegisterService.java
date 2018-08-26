package bs.model.services.register;

import java.util.Date;

import javax.persistence.NoResultException;

import bs.model.persistence.dao.AccountDao;
import bs.model.persistence.entities.AccountEntity;
import bs.model.services.security.PasswordHasher;

public class RegisterService {

	private AccountDao accountDao;
	
	private AccountNumberGenerator numberGenerator;
	
	private AccountEntity registeredAccount;
	
	private RegisterStatus status;
	
	public RegisterService() {
		accountDao = new AccountDao();
		numberGenerator = new AccountNumberGenerator();
		status = RegisterStatus.PENDING;
	}
	
	public boolean register(String password, String email) {
		AccountEntity generatedAccount = generateAccount(password, email);
		if (accountDao.create(generatedAccount)) {
			registeredAccount = generatedAccount;
			status = RegisterStatus.SUCCESS;
			return true;
		} else {
			status = RegisterStatus.FAILED;
			return false;
		}
	}
	
	private AccountEntity generateAccount(String password, String email) {
		AccountEntity generatedAccount = new AccountEntity();
		generatedAccount.setIdPerson(null);
		generatedAccount.setAccountNumber(numberGenerator.generateAccountNumber(accountDao));
		generatedAccount.setPassword(PasswordHasher.hashPassword(password));
		generatedAccount.setEmail(email);
		generatedAccount.setOpenDate(new Date());
		return generatedAccount;
	}
	
	public AccountEntity getRegisteredAccount() {
		if (registeredAccount == null) throw new NoResultException();
		else return registeredAccount;
	}
	
	public RegisterStatus getStatus() {
		return status;
	}
	
}
package bs.model.services.auth;

import bs.model.services.crypto.Hasher;

public class UserAuthData {

	private String accountNumber;
	
	private String password;
	
	public UserAuthData(String accountNumber, String password) {
		this.accountNumber = accountNumber;
		this.password = Hasher.hashPassword(password);
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
}

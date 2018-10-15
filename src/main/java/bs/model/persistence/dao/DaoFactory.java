package bs.model.persistence.dao;

public class DaoFactory {

	private DaoFactory() { }
	
	public AccountDao getAccountDao() {
		return new AccountDaoImpl();
	}
	
	public LoginDao getLoginDao() {
		return new LoginDaoImpl();
	}
	
	public NewsDao getNewsDao() {
		return new NewsDaoImpl();
	}
	
	public PersonDao getPersonDao() {
		return new PersonDaoImpl();
	}
	
}

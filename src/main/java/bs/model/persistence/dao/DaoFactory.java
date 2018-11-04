package bs.model.persistence.dao;

public class DaoFactory {

	private DaoFactory() { }
	
	/* new db schema */
	
	public static ClientDao getClientDao() {
		return new ClientDaoImpl();
	}
	
	/* deprecated ! */
	
	public static AccountDao getAccountDao() {
		return new AccountDaoImpl();
	}
	
	public static LoginDao getLoginDao() {
		return new LoginDaoImpl();
	}
	
	public static NewsDao getNewsDao() {
		return new NewsDaoImpl();
	}
	
	public static PersonDao getPersonDao() {
		return new PersonDaoImpl();
	}
	
}

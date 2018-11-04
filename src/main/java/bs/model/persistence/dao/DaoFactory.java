package bs.model.persistence.dao;

public class DaoFactory {

	private DaoFactory() { }
	
	public static AccountDao getAccountDao() {
		return new AccountDaoImpl();
	}
	
}

package bs.model.persistence.dao;

public class DaoFactory {

	private DaoFactory() { }
	
	public static AccountDao getAccountDao() {
		return new AccountDaoImpl();
	}
	
	public static AccountTypeDao getAccountTypeDao() {
		return new AccountTypeDaoImpl();
	}
	
	public static AddressDao getAddressDao() {
		return new AddressDaoImpl();
	}
	
	public static ClientDao getClientDao() {
		return new ClientDaoImpl();
	}
	
}
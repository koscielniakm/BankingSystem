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
	
	public static AddressTypeDao getAddressTypeDao() {
		return new AddressTypeDaoImpl();
	}
	
	public static AuthorizationDao getAuthorizationDao() {
		return new AuthorizationDaoImpl();
	}
	
	public static CardDao getCardDao() {
		return new CardDaoImpl();
	}
	
	public static ClientDao getClientDao() {
		return new ClientDaoImpl();
	}
	
}

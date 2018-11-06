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
	
	public static CardTypeDao getCardTypeDao() {
		return new CardTypeDaoImpl();
	}
	
	public static ClientDao getClientDao() {
		return new ClientDaoImpl();
	}
	
	public static ContactDao getContactDao() {
		return new ContactDaoImpl();
	}
	
	public static ContactTypeDao getContactTypeEntity() {
		return new ContactTypeDaoImpl();
	}
	
	public static CyclicalMoneyTransferDao getCyclicalMoneyTransferDao() {
		return new CyclicalMoneyTransferDaoImpl();
	}
	
	public static DocumentDao getDocumentDao() {
		return new DocumentDaoImpl();
	}
	
	public static DocumentTypeDao getDocumentTypeDao() {
		return new DocumentTypeDaoImpl();
	}
	
}

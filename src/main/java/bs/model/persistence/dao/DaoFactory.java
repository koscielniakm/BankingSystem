package bs.model.persistence.dao;

public class DaoFactory {

	private EntityClass entityClass;
	
	public DaoFactory(EntityClass entityClass) {
		this.entityClass = entityClass;
	}
	
	public Dao<?> getDao() {
		switch (entityClass) {
			case ACCOUNT:
				return new AccountDaoImpl();
			case LOGIN:
				return new LoginDaoImpl();
			case NEWS:
				return new NewsDaoImpl();
			case PERSON:
				return new PersonDaoImpl();
			default:
				throw new IllegalArgumentException();
		}
	}
	
}

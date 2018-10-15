package bs.model.persistence.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;

import bs.model.persistence.entities.LoginEntity;
import bs.model.persistence.validators.LoginValidator;

public class LoginDaoImpl extends AbstractDao<LoginEntity> implements Dao<LoginEntity> {

	private LoginValidator validator;
	
	public LoginDaoImpl() {
		validator = new LoginValidator();
	}
	
	@Override
	public LoginEntity create(LoginEntity login) {
		if (validator.validateBeforeCreate(login))
			return super.persistEntity(login);
		else
			throw new PersistenceException();
	}

	@Override
	public LoginEntity update(LoginEntity login) {
		if (validator.validateBeforeUpdate(login))
			return super.mergeEntity(login);
		else
			throw new IllegalArgumentException();
	}

	@Override
	public boolean delete(int id) {
		if (!validator.validateBeforeDelete(id)) return false;
		super.removeEntity(LoginEntity.class, id);
		return true;
	}

	@Override
	public LoginEntity getById(int id) {
		EntityManager entityManager = getEntityManager();
		LoginEntity login = entityManager.find(LoginEntity.class, id);
		return login;
	}

	@Override
	public List<LoginEntity> getAll() {
		EntityManager entityManager = getEntityManager();
		List<LoginEntity> loginList = entityManager
			.createQuery("FROM LoginEntity log", LoginEntity.class).getResultList();
		return loginList;
	}
	
}

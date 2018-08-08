package bs.model.persistence.dao;

import java.util.List;

import javax.persistence.EntityManager;

import bs.model.persistence.entities.LoginEntity;

public class LoginDao extends AbstractDao<LoginEntity> implements Dao<LoginEntity> {

	private LoginValidator validator;
	
	public LoginDao() {
		validator = new LoginValidator();
	}
	
	@Override
	public boolean create(LoginEntity login) {
		if (!validator.validateBeforeCreate(login)) return false;
		super.persistEntity(login);
		return true;
	}

	@Override
	public boolean update(LoginEntity login) {
		if (!validator.validateBeforeUpdate(login)) return false;
		super.mergeEntity(login);
		return true;
	}

	@Override
	public boolean delete(int id) {
		if (!validator.validateBeforeDelete(id)) return false;
		super.removeEntity(LoginEntity.class, id);
		return true;
	}

	@Override
	public LoginEntity getById(int id) {
		EntityManager entityManager = getPersistenceSupport().getEntityManager();
		LoginEntity login = entityManager.find(LoginEntity.class, id);
		return login;
	}

	@Override
	public List<LoginEntity> getAll() {
		EntityManager entityManager = getPersistenceSupport().getEntityManager();
		List<LoginEntity> loginList = entityManager
			.createQuery("FROM LoginEntity log", LoginEntity.class).getResultList();
		return loginList;
	}
	
}

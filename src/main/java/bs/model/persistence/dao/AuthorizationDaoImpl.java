package bs.model.persistence.dao;

import java.util.List;

import javax.persistence.EntityManager;

import bs.model.persistence.entities.AuthorizationEntity;

public class AuthorizationDaoImpl extends AbstractDao<AuthorizationEntity> implements AuthorizationDao  {

	@Override
	public AuthorizationEntity create(AuthorizationEntity obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AuthorizationEntity update(AuthorizationEntity obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean delete(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public AuthorizationEntity getById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<AuthorizationEntity> getAll() {
		EntityManager entityManager = getEntityManager();
		List<AuthorizationEntity> list = entityManager
			.createQuery("FROM AuthorizationEntity a", AuthorizationEntity.class).getResultList();
		return list;
	}

}

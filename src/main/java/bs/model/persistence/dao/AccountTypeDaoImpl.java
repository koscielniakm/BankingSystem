package bs.model.persistence.dao;

import java.util.List;

import javax.persistence.EntityManager;

import bs.model.persistence.entities.AccountTypeEntity;

public class AccountTypeDaoImpl extends AbstractDao<AccountTypeEntity> implements AccountTypeDao {

	@Override
	public AccountTypeEntity create(AccountTypeEntity obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AccountTypeEntity update(AccountTypeEntity obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean delete(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public AccountTypeEntity getById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<AccountTypeEntity> getAll() {
		EntityManager entityManager = getEntityManager();
		List<AccountTypeEntity> list = entityManager
			.createQuery("FROM AccountTypeEntity a", AccountTypeEntity.class).getResultList();
		return list;
	}

}

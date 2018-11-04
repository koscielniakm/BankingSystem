package bs.model.persistence.dao;

import java.util.List;

import javax.persistence.EntityManager;

import bs.model.persistence.entities.AccountEntity;

public class AccountDaoImpl extends AbstractDao<AccountEntity> implements AccountDao {

	@Override
	public AccountEntity create(AccountEntity obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AccountEntity update(AccountEntity obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean delete(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public AccountEntity getById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<AccountEntity> getAll() {
		EntityManager entityManager = getEntityManager();
		List<AccountEntity> list = entityManager
			.createQuery("FROM AccountEntity a", AccountEntity.class).getResultList();
		return list;
	}

}

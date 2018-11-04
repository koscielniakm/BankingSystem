package bs.model.persistence.dao;

import java.util.List;

import javax.persistence.EntityManager;

import bs.model.persistence.entities.ClientEntity;

public class ClientDaoImpl extends AbstractDao<ClientEntity> implements ClientDao {

	@Override
	public ClientEntity create(ClientEntity obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ClientEntity update(ClientEntity obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean delete(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ClientEntity getById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ClientEntity> getAll() {
		EntityManager entityManager = getEntityManager();
		List<ClientEntity> list = entityManager
			.createQuery("FROM ClientEntity c", ClientEntity.class).getResultList();
		return list;
	}

}

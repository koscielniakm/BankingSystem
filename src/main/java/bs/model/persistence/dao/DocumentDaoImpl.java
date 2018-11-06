package bs.model.persistence.dao;

import java.util.List;

import javax.persistence.EntityManager;

import bs.model.persistence.entities.DocumentEntity;

public class DocumentDaoImpl extends AbstractDao<DocumentEntity> implements DocumentDao {

	@Override
	public DocumentEntity create(DocumentEntity obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DocumentEntity update(DocumentEntity obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean delete(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public DocumentEntity getById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<DocumentEntity> getAll() {
		EntityManager entityManager = getEntityManager();
		List<DocumentEntity> list = entityManager
			.createQuery("FROM DocumentEntity d", DocumentEntity.class).getResultList();
		return list;
	}
	
}

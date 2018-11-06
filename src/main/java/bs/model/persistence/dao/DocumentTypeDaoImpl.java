package bs.model.persistence.dao;

import java.util.List;

import javax.persistence.EntityManager;

import bs.model.persistence.entities.DocumentTypeEntity;

public class DocumentTypeDaoImpl extends AbstractDao<DocumentTypeEntity> implements DocumentTypeDao {

	@Override
	public DocumentTypeEntity create(DocumentTypeEntity obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DocumentTypeEntity update(DocumentTypeEntity obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean delete(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public DocumentTypeEntity getById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<DocumentTypeEntity> getAll() {
		EntityManager entityManager = getEntityManager();
		List<DocumentTypeEntity> list = entityManager
			.createQuery("FROM DocumentTypeEntity d", DocumentTypeEntity.class).getResultList();
		return list;
	}
	
}

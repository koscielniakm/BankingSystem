package bs.model.persistence.validators;

import bs.model.persistence.entities.DbEntity;

/**
 * Inteface for DAO validators.
 * @author Mateusz
 * @param <T> Some DbEntity instance.
 */
public interface DaoValidator<T extends DbEntity> {
	boolean validateBeforeCreate(T entity);
	boolean validateBeforeUpdate(T entity);
	boolean validateBeforeDelete(Integer id);
}

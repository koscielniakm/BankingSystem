package bs.model.persistence.validators;

public interface DaoValidator<T> {
	boolean validateBeforeCreate(T entity);
	boolean validateBeforeUpdate(T entity);
	boolean validateBeforeDelete(Integer id);
}

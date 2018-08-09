package bs.model.persistence.validators;

public interface DaoValidator<T> {
	public boolean validateBeforeCreate(T obj);
	public boolean validateBeforeUpdate(T obj);
	public boolean validateBeforeDelete(Integer id);
}

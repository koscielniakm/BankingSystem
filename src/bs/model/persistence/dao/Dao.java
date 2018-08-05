package bs.model.persistence.dao;

import java.util.List;

public interface Dao<T> {
	public boolean create(T obj);
	public boolean update(T obj);
	public boolean delete(int id);
	public T getById(int id);
	public List<T> getAll();
}

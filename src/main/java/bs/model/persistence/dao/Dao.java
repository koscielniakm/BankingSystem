package bs.model.persistence.dao;

import java.util.List;

public interface Dao<T> {
	public T create(T obj);
	public T update(T obj);
	public boolean delete(int id);
	public T getById(int id);
	public List<T> getAll();
}

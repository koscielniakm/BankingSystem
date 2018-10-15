package bs.model.persistence.dao;

import java.util.List;

import bs.model.persistence.entities.NewsEntity;

public interface NewsDao extends Dao<NewsEntity> {
	
	public List<NewsEntity> getLast(Integer number);
	
}

package bs.model.services.misc;

import java.util.List;

import bs.model.persistence.dao.NewsDao;
import bs.model.persistence.entities.NewsEntity;

/**
 * Management service for NewsEntity class.
 * @author Mateusz
 */
public class NewsService {

	private NewsDao dao;
	
	public NewsService() {
		dao = new NewsDao();
	}
	
	/**
	 * @return All news.
	 */
	public List<NewsEntity> getAll() {
		return dao.getAll();
	}
	
	/**
	 * @param number Amount of last news. (ex. last 5 news)
	 * @return last [number] news from database.
	 */
	public List<NewsEntity> getLast(Integer number) {
		return dao.getLast(number);
	}
	
}

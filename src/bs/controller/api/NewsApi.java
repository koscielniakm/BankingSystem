package bs.controller.api;

import java.util.List;

import javax.json.Json;
import javax.json.JsonArrayBuilder;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import bs.model.persistence.entities.NewsEntity;
import bs.model.services.misc.NewsService;

@Path("/news/")
public class NewsApi {

	@GET
	@Path("/")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAll() {
		List<NewsEntity> newsList = new NewsService().getAll();
		if (newsList.size() == 0 || newsList == null) 
			return Response.noContent().build();
		JsonArrayBuilder jsonBuilder = Json.createArrayBuilder();
		for (NewsEntity news: newsList) jsonBuilder.add(Json
			.createObjectBuilder()
			.add("Date", news.getDate().toString())
			.add("Title", news.getTitle())
			.add("Content", news.getContent()));
		return Response.ok(jsonBuilder.build()).build();
	}
	
	@GET
	@Path("/last/")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getLast() {
		List<NewsEntity> newsList = new NewsService().getLast(5);
		if (newsList.size() == 0 || newsList == null) 
			return Response.noContent().build();
		JsonArrayBuilder jsonBuilder = Json.createArrayBuilder();
		for (NewsEntity news: newsList) jsonBuilder.add(Json
			.createObjectBuilder()
			.add("Date", news.getDate().toString())
			.add("Title", news.getTitle())
			.add("Content", news.getContent()));
		return Response.ok(jsonBuilder.build()).build();
	}
	
}

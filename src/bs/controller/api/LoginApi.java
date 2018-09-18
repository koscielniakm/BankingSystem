package bs.controller.api;

import javax.json.JsonObject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import bs.model.services.auth.LoginService;

@Path("/")
public class LoginApi {
	
	@POST
	@Path("/login")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response login(JsonObject incomingData) {
		String incomingInput = incomingData.getString("Input");
		String incomingPassword = incomingData.getString("Password");
		LoginService loginService = new LoginService(incomingInput, incomingPassword);
		boolean status = loginService.login();
		if (status) return Response.ok().build();
		else return Response.status(400).build();	
	}
	
}

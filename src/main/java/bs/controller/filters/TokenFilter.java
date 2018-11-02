package bs.controller.filters;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.ext.Provider;

import bs.model.config.Finals;

@Provider
public class TokenFilter implements ContainerResponseFilter {

   @Override
   public void filter(ContainerRequestContext requestContext, ContainerResponseContext responseContext) {
	   String token = requestContext.getHeaderString(Finals.JTW_HEADER_NAME);
   }

}
package ec.edu.ups.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/prueba")
public class IntentoRest {

    @GET @Produces(MediaType.TEXT_PLAIN)
    public String saludar() {
	return "Hola mundo, desde Restful FUNCIONA";
    }

}

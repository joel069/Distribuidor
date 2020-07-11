package ec.edu.ups.rest;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import ec.edu.ups.ejb.ProductoFacade;
import ec.edu.ups.modelo.Producto;

@Path("/prueba")
public class IntentoRest {
	
	@EJB
	private ProductoFacade ejbProductoFacade;
	
	

    @GET @Produces(MediaType.TEXT_PLAIN)
    public String saludar() {
	return "Hola mundo, desde Restful FUNCIONA";
    }
    
    @GET
    @Path("/ListaProductos/")
    @Produces(MediaType.APPLICATION_JSON)
    public Response listProductos() {
    	
    	List<Producto> list = new ArrayList<Producto>();
    	
    	Jsonb jsonb = JsonbBuilder.create();
    	
    	//list=ejbProductoFacade.findAll();
    	list = Producto.serializeProducto(ejbProductoFacade.findAll());
    	
    	
		return Response.ok(jsonb.toJson(list))
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Headers", "origin, content-type, accept, authorization")
				.header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE").build();
    	
    	
    }

}

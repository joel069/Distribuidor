package ec.edu.ups.rest;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import ec.edu.ups.ejb.BodegaFacade;
import ec.edu.ups.ejb.CategoriaFacade;
import ec.edu.ups.ejb.ProductoFacade;
import ec.edu.ups.ejb.StockFacade;
import ec.edu.ups.modelo.Bodega;
import ec.edu.ups.modelo.Categoria;
import ec.edu.ups.modelo.Producto;
import ec.edu.ups.modelo.Stock;

@Path("/prueba")
public class ApiREST {
	
	@EJB
	private ProductoFacade ejbProductoFacade;
	@EJB private CategoriaFacade ejbCategoriaFacade;
	@EJB private BodegaFacade ejbBodegaFacade;
	@EJB private StockFacade ejbStockFacade;
	
	

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
    //Metod Funcionando
    
    @GET
    @Path("/Categorias/")
    @Produces(MediaType.APPLICATION_JSON)
    public Response listCategorias() {
    	List<Categoria> list = new ArrayList<Categoria>();
    	Jsonb jsonb = JsonbBuilder.create();
    	
    	list=Categoria.serializeCategoria(ejbCategoriaFacade.findAll());
		return Response.ok(jsonb.toJson(list))
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Headers", "origin, content-type, accept, authorization")
				.header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE").build();
    }
    
    @GET
    @Path("/Bodegas")
    @Produces(MediaType.APPLICATION_JSON)
    public Response listBodegas() {
    	List<Bodega> list = new ArrayList<Bodega>();
    	Jsonb jsonb = JsonbBuilder.create();
    	
    	list=Bodega.serializeBodega(ejbBodegaFacade.findAll());
		return Response.ok(jsonb.toJson(list))
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Headers", "origin, content-type, accept, authorization")
				.header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE").build();
    }

    
    @GET
    @Path("/ProductosByBodega/{nombreB}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response listProductosBodega(@PathParam("nombreB") String nombreB) {
    	Jsonb jsonb = JsonbBuilder.create();
    	
    	Bodega bo= new Bodega();
		bo=Bodega.serializeBodega2(ejbBodegaFacade.nombreBodega(nombreB));
		
		System.out.println(ejbStockFacade.listaInventario(bo));
		List<Stock> lisStocks = new ArrayList<Stock>();
		//lisStocks=ejbStockFacade.listaInventario(bo);
		lisStocks=Stock.serializeStock(ejbStockFacade.listaInventario(bo));
    	
    	
		return Response.ok(jsonb.toJson(lisStocks))
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Headers", "origin, content-type, accept, authorization")
				.header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE").build();
    	
    }
}

package ec.edu.ups.rest;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;
import javax.ws.rs.Consumes;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.glassfish.api.Param;

import ec.edu.ups.ejb.BodegaFacade;
import ec.edu.ups.ejb.CategoriaFacade;
import ec.edu.ups.ejb.ProductoFacade;

import ec.edu.ups.ejb.UsuarioFacade;

import ec.edu.ups.ejb.StockFacade;
import ec.edu.ups.modelo.Bodega;

import ec.edu.ups.modelo.Categoria;
import ec.edu.ups.modelo.Producto;
import ec.edu.ups.modelo.Rol;
import ec.edu.ups.modelo.Stock;
import ec.edu.ups.modelo.Usuario;

@Path("/prueba")
public class ApiREST {
	private Usuario usuario;
	private Usuario usu;
	
	@EJB
	private ProductoFacade ejbProductoFacade;
	@EJB private CategoriaFacade ejbCategoriaFacade;

	@EJB private UsuarioFacade ejbUsuarioFacade;

	@EJB private BodegaFacade ejbBodegaFacade;
	@EJB private StockFacade ejbStockFacade;




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
    

    @POST
    @Path("/bode/{nombre}")
    @Produces(MediaType.TEXT_PLAIN)
    @Consumes(MediaType.TEXT_PLAIN)
    public Response bode(@PathParam("nombre")String nombre) {
    	//Jsonb jsonb = JsonbBuilder.create();    	
    	System.out.println("Aquiiiiiiiiiiiiiiiiiiiiii");      	
    	System.out.println(nombre);
    	return Response.ok("aquiiiiiiiiii"+nombre)
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Headers", "origin, content-type, accept, authorization")
				.header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE").build();
    	
    	
    }
    
    
    @POST
    @Path("/personas")
    @Consumes(MediaType.APPLICATION_JSON)
    //@Produces(MediaType.APPLICATION_JSON)
    public Response post(@FormParam("nombres") String nombre,@FormParam("apellidos") String apellidos,@FormParam("telefono") String telefono,
    		@FormParam("cedula") String cedula,@FormParam("correo") String correo,@FormParam("contrasena") String contrasena)
          throws IOException{
    	System.out.println("Metodo crear");
    	Jsonb jsonb=JsonbBuilder.create();
    	
    	//@FormParam
    	//usuario= jsonb.fromJson(nombre, Usuario.class);
    	
    	Rol rol3=new Rol();
	    rol3.setNombre("cliente");
    	Usuario usu=new Usuario(nombre,apellidos,telefono,cedula,correo,contrasena,rol3);
    	System.out.println(nombre);
    	System.out.println(apellidos);
    	System.out.println(usu);
    	//ejbUsuarioFacade.create(usu);
    	//Response.ok(jsonb.toJson(usu)).build();
    	return Response.ok(jsonb.toJson(usu))
    			.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Headers", "origin, content-type, accept, authorization")
				.header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE").build();
    }
    
    
    
       
    /*
    @POST
    @Path("/personas")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.TEXT_PLAIN)
    public Usuario add(@FormParam("usuarios") Usuario usuario)
    		throws IOException {
    	System.out.println(usuario);
    	return usuario;
    }

   */
    

}

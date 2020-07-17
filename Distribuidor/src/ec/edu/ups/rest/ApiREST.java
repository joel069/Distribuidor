package ec.edu.ups.rest;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;
import javax.persistence.PreUpdate;
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

import com.sun.rowset.internal.Row;

import ec.edu.ups.controlador.Roww;
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
	List<Roww> listRow = new ArrayList<Roww>();
	
	@EJB
	private ProductoFacade ejbProductoFacade;
	@EJB private CategoriaFacade ejbCategoriaFacade;

	@EJB private UsuarioFacade ejbUsuarioFacade;

	@EJB private BodegaFacade ejbBodegaFacade;
	@EJB private StockFacade ejbStockFacade;
	
	
	//Variables
	List<Producto> lisProducto = new ArrayList<Producto>();
	



	
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
    //@Path("/personas")
    //@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
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
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.TEXT_PLAIN)
    public Response post(@FormParam("nombres") String nombre,@FormParam("apellidos") String apellidos,@FormParam("telefono") String telefono,
    		@FormParam("cedula") String cedula,@FormParam("correo") String correo,@FormParam("contrasena") String contrasena)
          throws IOException{
    	System.out.println("Metodo crear");

    	System.out.println("Nombre " + nombre);
    	System.out.println("Apellido " + apellidos);
    	System.out.println("Telefono " + telefono);
    	System.out.println("Cedula " + cedula);
    	System.out.println("Correo " + correo);
    	System.out.println("Contrasena " + contrasena);
    	
    	Rol rol3=new Rol();
	    rol3.setNombre("cliente");

    	usu=new Usuario(nombre,apellidos,telefono,cedula,correo,contrasena,rol3);
    	System.out.println("Usuario tipo Usuario-------------------->"+usu.toString());
    	ejbUsuarioFacade.create(usu);

    	return Response.ok("Creado")
    			.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Headers", "origin, content-type, accept, authorization")
				.header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE").build();
    }




    @POST
    @Path("/inicio")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public Response inicio(@FormParam("correo") String correo,@FormParam("contrasena") String contrasena)
          throws IOException{
    	System.out.println("Metodo crear");
        Usuario us=new Usuario();
    	System.out.println("Correo " + correo);
    	System.out.println("Contrasena " + contrasena);
    	
    	Usuario usu=new Usuario();
    	usu.setCorreo(correo);
    	String correoo=usu.getCorreo();
    	
    	usu.setContraseña(contrasena);
    	String contrasenaa=usu.getContraseña();
    	
    	us = ejbUsuarioFacade.inicio(correoo, contrasenaa);
        if(us !=null) 
        {
    	return Response.ok("Iniciado")
        
    			.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Headers", "origin, content-type, accept, authorization")
				.header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE").build();
        }
        
        return Response.ok("No creado").build();
    }

    
    @POST
    @Path("/ProductosByBodegaCategorias/{nombreB}/{nombreC}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response listProductosBodegaCategorias(@PathParam("nombreB") String nombreB,@PathParam("nombreC")String nombreC) {
    	Jsonb jsonb = JsonbBuilder.create();
    	
    	System.out.println(nombreB);
    	System.out.println(nombreC);
    	
    	
    	//Bodega bo= new Bodega();
		
		System.out.println(ejbStockFacade.bodegasCategorias_Productos(nombreB, nombreC));
		List<Stock> lisStocks = new ArrayList<Stock>();
		//lisStocks=ejbStockFacade.listaInventario(bo);
		lisStocks=Stock.serializeStock(ejbStockFacade.bodegasCategorias_Productos(nombreB, nombreC));
		System.out.println(lisStocks);
		
    	
    	
		return Response.ok(jsonb.toJson(lisStocks))
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Headers", "origin, content-type, accept, authorization")
				.header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE").build();

    }
    /*
    @POST
    @Path("/AgregarProductosLista")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.APPLICATION_JSON)
    public Response ListaProductos(@PathParam("nombre")String nombre,@PathParam("descripcion")String descripcion,
    		@PathParam("preciopublico")String preciopublico, @PathParam("stock")String stock, @PathParam("cantidad")String cantidad
    		,@PathParam("preciounitario")String preciounitario) {
    	
    	System.out.println("NombreProducto-->"+nombre);
    	System.out.println("DescripcionProducto-->"+descripcion);
    	System.out.println("PrecioProducto-->"+preciopublico);
    	System.out.println("StockProducto-->"+stock);
    	System.out.println("CantidadProducto-->"+cantidad);
    	
    	
    	double precioP= Double.parseDouble(preciopublico);
    	double precioU=Double.parseDouble(preciounitario);
    	int stockP = Integer.valueOf(stock);
    	int Cantidad = Integer.valueOf(cantidad);
    	
    	System.out.println("Lleegooo");
    	this.listRow.add(new Roww(nombre,descripcion,precioP,precioU,stockP,Cantidad));
    	System.out.println(listRow);
    	
    	
		return null;
    	
    }*/
    
    @POST
    @Path("/AgregarProductosLista")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public Response ListaProductos(String jsonproducto) {
    	
    
    	Jsonb jsonb = JsonbBuilder.create();
    	
    	List<Roww> list = jsonb.fromJson(jsonproducto, new ArrayList<Roww>() {}.getClass().getGenericSuperclass());
    	
    	for (Roww row : list) {
			
    		System.out.println("Nombre--->" +row.getNombre1());
    		System.out.println("Descripcion--->" +row.getDescripcion());
    		System.out.println("Punitario--->" +row.getPun());
    		System.out.println("Ppublico--->" +row.getPpu());
    		System.out.println("Stock--->" +row.getStock());
    		System.out.println("Cantidad--->" +row.getCantidad());
		} 
			
		
    	System.out.println("La lista es :" +list);
    	
    //	System.out.println("Lleegooo");
    	//this.listRow.add(new Roww(nombre,descripcion,precioP,precioU,stockP,Cantidad));
    //	System.out.println(listRow);
    	
    	return Response.ok("Creado")
    			.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Headers", "origin, content-type, accept, authorization")
				.header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE").build();
    	
		
		
    	
    }
    
  }    
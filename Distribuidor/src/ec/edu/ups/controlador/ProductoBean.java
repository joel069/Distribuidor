package ec.edu.ups.controlador;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.annotation.FacesConfig;
import javax.inject.Named;

import ec.edu.ups.ejb.CategoriaFacade;
import ec.edu.ups.ejb.ProductoFacade;
import ec.edu.ups.ejb.StockFacade;
import ec.edu.ups.modelo.Bodega;
import ec.edu.ups.modelo.Categoria;
import ec.edu.ups.modelo.Producto;
import ec.edu.ups.modelo.Stock;


@FacesConfig(version = FacesConfig.Version.JSF_2_3)
@Named
@SessionScoped
public class ProductoBean implements Serializable{

	private static final long serialVersionUID = 1L;
	//
	@EJB
	private ProductoFacade ejbProductoFacade;
	private CategoriaFacade ejbCategoriaFacade;
	@EJB
	private StockFacade ejbStockFacade;
	private String nombre;
	private String descripcion;
	private double preciounitario;
	private double preciopublico;
	private String categoria;
	private List<Producto> listaProductos;
	private List<Producto> listaProductos1;
	private Producto producto;
	private Stock stock1;
	private int stock;
	private String bodega;
	
	public ProductoBean() {
		
	}
	
	@PostConstruct
	public void init() {
		//ejbProductoFacade.create(new Producto("Papel","Scot",1.35,1.12));
		//ejbProductoFacade.create(new Producto("Deja","Ariel",2.49,1.89));
		this.producto=new Producto();
		this.stock1= new Stock();
		listaProductos = ejbProductoFacade.findAll();
	}

//Getters and Setters.
	
	
	
	public String getNombre() {
		return nombre;
	}

	

	public Stock getStock1() {
		return stock1;
	}

	public void setStock1(Stock stock1) {
		this.stock1 = stock1;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public double getPreciounitario() {
		return preciounitario;
	}

	public void setPreciounitario(double preciounitario) {
		this.preciounitario = preciounitario;
	}

	public double getPreciopublico() {
		return preciopublico;
	}

	public void setPreciopublico(double preciopublico) {
		this.preciopublico = preciopublico;
	}

	public Producto[] getListaProductos() {
		return listaProductos.toArray(new Producto[0]);
	}

	public void setListaProductos(List<Producto> listaProductos) {
		this.listaProductos = listaProductos;
	}
	
	
	public String getCategoria() {
	
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
//Getters and setters para bodega
	public String getBodega() {
		return bodega;
	}

	public void setBodega(String bodega) {
		this.bodega = bodega;
	}

	//Metodos para agregar, listar, modificar y Eliminar
	public String add() {
		try {
			producto.setNombre(this.nombre);
			producto.setDescripcion(this.descripcion);
			producto.setPreciounitario(this.preciounitario);
			producto.setPreciopublico(this.preciopublico);
			producto.setCategoria(buscar());
			producto.setStock(this.stock);
			ejbProductoFacade.create(producto);
			listaProductos = ejbProductoFacade.findAll();
			stock1.setBodega(bode());
			stock1.setProducto(producto);
			ejbStockFacade.create(stock1);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return null;
	}
	
	public String remove(Producto p) {
		ejbProductoFacade.remove(p);
		listaProductos = ejbProductoFacade.findAll();
		return null;
	}
	
	public String edit(Producto p) {
		p.setEditable(true);
		return null;
	}
	
	public String save(Producto p) {
		ejbProductoFacade.edit(p);
		p.setEditable(false);
		return null;
	}
	
	public Categoria buscar() {
		System.out.println(categoria);
		Categoria ca = new Categoria();
		
		ca=ejbProductoFacade.validar(categoria);
		System.out.println("Estamos en el metodo buscar:---------");
		System.out.println(ca.toString());
		System.out.println(" Id de la categoria es: "+ ca.getId());
		return ca;
	}
	
	public Categoria buscarProductos() {
		System.out.println(categoria);
		Categoria ca = new Categoria();
		ca=ejbProductoFacade.validar(categoria);
		System.out.println("Se busca el id de la categoria para los productos.");
		System.out.println(ca.toString());
		int id=ca.getId();
		System.out.println(id);
		listaProductos=ejbProductoFacade.buscarProductos(id);
		System.out.println("La lista de Productos es:" +listaProductos);
		return ca;
		
	}
	
	public Producto buscarProductosnombre() {
		Producto pro = new Producto();
		String nombre=pro.getNombre();
		System.out.println(nombre);
		listaProductos1=ejbProductoFacade.buscarProductosnombre(nombre);
		System.out.println("La lista de Productos es:" +listaProductos1);
		return pro;
		
	}
	public Bodega bode() {
		Bodega bo= new Bodega();
		bo=ejbProductoFacade.nombreBodega(bodega);
		System.out.println(bo);
		return bo;
	}
}

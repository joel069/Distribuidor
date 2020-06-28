package ec.edu.ups.controlador;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.annotation.FacesConfig;
import javax.inject.Named;

import ec.edu.ups.ejb.ProductoFacade;
import ec.edu.ups.modelo.Producto;


@FacesConfig(version = FacesConfig.Version.JSF_2_3)
@Named
@SessionScoped
public class ProductoBean implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@EJB
	private ProductoFacade ejbProductoFacade;
	private String nombre;
	private String descripcion;
	private double preciounitario;
	private double preciopublico;
	private List<Producto> listaProductos;
	
	public ProductoBean() {
		
	}
	
	@PostConstruct
	public void init() {
		ejbProductoFacade.create(new Producto("Papel","Scot",1.35,1.12));
		ejbProductoFacade.create(new Producto("Deja","Ariel",2.49,1.89));
		listaProductos = ejbProductoFacade.findAll();
	}

//Getters and Setters.
	public String getNombre() {
		return nombre;
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
	
//Metodos para agregar, listar, modificar y Eliminar
	public String add() {
		ejbProductoFacade.create(new Producto(this.nombre,this.descripcion,this.preciounitario,this.preciopublico));
		listaProductos = ejbProductoFacade.findAll();
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
}

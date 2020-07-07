package ec.edu.ups.controlador;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.annotation.FacesConfig;
import javax.inject.Named;

import ec.edu.ups.ejb.FacturaDetalleFacade;
import ec.edu.ups.ejb.ProductoFacade;
import ec.edu.ups.modelo.FacturaDetalle;
import ec.edu.ups.modelo.Producto;

@FacesConfig(version = FacesConfig.Version.JSF_2_3)
@Named
@SessionScoped
public class FacturaDetaBean implements Serializable{
	
	private static final long serialVersionUID = 1L;
	//
	
	@EJB
	private FacturaDetalleFacade ejbFacturaDetalleFacade; 
	private ProductoFacade ejbProductoFacade;
	private int cantidad;
	private double subtotal;
	//public String categoria;
	private double total;
	private Producto prod;
	private double iva;
	private double descuento;
	private String producto;
	private List<Producto> listproducto;
	private List<FacturaDetalle> facdetalle;
	
	public FacturaDetaBean() {
		
	}
	
	@PostConstruct
	public void init() {
		//ejbProductoFacade.create(new Producto("Papel","Scot",1.35,1.12));
		//ejbProductoFacade.create(new Producto("Deja","Ariel",2.49,1.89));
		facdetalle = ejbFacturaDetalleFacade.findAll();
		listproducto= new ArrayList<Producto>();	
	}

	public FacturaDetalleFacade getEjbFacturaDetalleFacade() {
		return ejbFacturaDetalleFacade;
	}

	public void setEjbFacturaDetalleFacade(FacturaDetalleFacade ejbFacturaDetalleFacade) {
		this.ejbFacturaDetalleFacade = ejbFacturaDetalleFacade;
	}

	public ProductoFacade getEjbProductoFacade() {
		return ejbProductoFacade;
	}

	public void setEjbProductoFacade(ProductoFacade ejbProductoFacade) {
		this.ejbProductoFacade = ejbProductoFacade;
	}



	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public double getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(double subtotal) {
		this.subtotal = subtotal;
	}
	
	
	public double getTotalparcial() {
		return total;
	}

	public void setTotalparcial(double totalparcial) {
		this.total = totalparcial;
	}

	

	public double getIva() {
		return iva;
	}

	public void setIva(double iva) {
		this.iva = iva;
	}
	public double getDescuento() {
		return descuento;
	}

	public void setDescuento(double descuento) {
		this.descuento = descuento;
	}

	public String getProducto() {
		return producto;
	}

	public void setProducto(String producto) {
		this.producto = producto;
	}

	public List<Producto> getListproducto() {
		return listproducto;
	}

	public void setListproducto(List<Producto> listproducto) {
		this.listproducto = listproducto;
	}

	public List<FacturaDetalle> getFacdetalle() {
		return facdetalle;
	}

	public void setFacdetalle(List<FacturaDetalle> facdetalle) {
		this.facdetalle = facdetalle;
	}
	
	//Metodos de CRUD
	
	public String add() {
		ejbFacturaDetalleFacade.create(new FacturaDetalle(this.cantidad,this.subtotal,this.total,this.descuento,buscarpro()));
		listproducto = ejbProductoFacade.findAll();
		
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
	
	
	public Producto buscarpro() {
		
		
		System.out.println(producto);
		prod=ejbFacturaDetalleFacade.buscarProductos(producto);
		String nombre = prod.getNombre();
		System.out.println("EL nombre es:" +nombre);
		
		return prod;	
		
	}
	
	public Producto getProd() {
		return prod;
	}

	public void setProd(Producto prod) {
		this.prod = prod;
	}

	public double calcularTotalParcial(){
		
		double valor=0 ;
		
		if(cantidad > 1) {
			
			valor = prod.getPreciounitario() * cantidad;
			System.out.println(valor);	
		}
		return valor;
	
	}
	
	
	
	
	

}

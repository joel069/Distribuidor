package ec.edu.ups.controlador;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.annotation.FacesConfig;
import javax.inject.Named;

import com.sun.rowset.internal.Row;

import ec.edu.ups.ejb.FacturaCabeceraFacade;
import ec.edu.ups.ejb.FacturaDetalleFacade;
import ec.edu.ups.ejb.PersonaFacade;
import ec.edu.ups.ejb.ProductoFacade;
import ec.edu.ups.ejb.UsuarioFacade;
import ec.edu.ups.modelo.FacturaCabecera;
import ec.edu.ups.modelo.FacturaDetalle;
import ec.edu.ups.modelo.Persona;
import ec.edu.ups.modelo.Producto;
import ec.edu.ups.modelo.Usuario;

@FacesConfig(version = FacesConfig.Version.JSF_2_3)
@Named
@SessionScoped
public class FacturaDetaBean implements Serializable{
	
	private static final long serialVersionUID = 1L;
	//
	
	@EJB
	private FacturaCabeceraFacade ejbFacturaCabeceraFacade; 
	@EJB
	private FacturaDetalleFacade ejbFacturaDetalleFacade; 
	
	
	private PersonaFacade personaFacade;
	private ProductoFacade ejbProductoFacade;
	private int cantidad;
	private double subtotal;
	//public String categoria;
	private double total;
	private Producto prod;
	private FacturaCabecera faccabe;
	private FacturaDetalle facdeta;
	private double iva;
	private double descuento;
	private String producto;
	private String persona;
	private String fecha;
	private List<Producto> listproducto;
	private List<FacturaDetalle> facdetalle;
	private List<FacturaCabecera> faccabecera;
	
	
	public FacturaDetaBean() {
		
	}
	
	@PostConstruct
	public void init() {
		//ejbProductoFacade.create(new Producto("Papel","Scot",1.35,1.12));
		//ejbProductoFacade.create(new Producto("Deja","Ariel",2.49,1.89));
		//facdetalle = ejbFacturaDetalleFacade.findAll();
		//faccabecera= ejbFacturaCabeceraFacade.findAll();
		this.listproducto= new ArrayList<Producto>();
		this.prod = new Producto();
		this.faccabe = new FacturaCabecera();
		this.facdeta = new FacturaDetalle();
		
		
	}
	
 /*
	public FacturaDetalleFacade getEjbFacturaDetalleFacade() {
		return ejbFacturaDetalleFacade;
	}

	public void setEjbFacturaDetalleFacade(FacturaDetalleFacade ejbFacturaDetalleFacade) {
		this.ejbFacturaDetalleFacade = ejbFacturaDetalleFacade;
	}
*/
	public ProductoFacade getEjbProductoFacade() {
		return ejbProductoFacade;
	}

	public void setEjbProductoFacade(ProductoFacade ejbProductoFacade) {
		this.ejbProductoFacade = ejbProductoFacade;
	}
	
	public FacturaCabeceraFacade getEjbFacturaCabeceraFacade() {
		return ejbFacturaCabeceraFacade;
	}
	
	public PersonaFacade getPersonaFacade() {
		return personaFacade;
	}

	public void setPersonaFacade(PersonaFacade personaFacade) {
		this.personaFacade = personaFacade;
	}

	public String getPersona() {
		return persona;
	}

	public void setPersona(String persona) {
		this.persona = persona;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public List<FacturaCabecera> getFaccabecera() {
		return faccabecera;
	}

	public void setFaccabecera(List<FacturaCabecera> faccabecera) {
		this.faccabecera = faccabecera;
	}

	
	public FacturaDetalle getFacdeta() {
		return facdeta;
	}

	public void setFacdeta(FacturaDetalle facdeta) {
		this.facdeta = facdeta;
	}

	public void setEjbFacturaCabeceraFacade(FacturaCabeceraFacade ejbFacturaCabeceraFacade) {
		this.ejbFacturaCabeceraFacade = ejbFacturaCabeceraFacade;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public FacturaCabecera getFaccabe() {
		return faccabe;
	}

	public void setFaccabe(FacturaCabecera faccabe) {
		this.faccabe = faccabe;
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
		
		faccabe.setFecha(this.fecha);
		faccabe.setFacturacab(buscarPersonanombre());;
		faccabe.setEstado("activo");
		faccabe.setTotal(50);
		
		facdeta.setCantidad(cantidad);
		facdeta.setProid(buscarpro());
		facdeta.setFaccabeid(faccabe);
		facdeta.setSubtotal(12.01);
		facdeta.setTotal(20.00);
		System.out.println(faccabe);
		System.out.println(facdeta);
		
		ejbFacturaCabeceraFacade.create(faccabe);
		ejbFacturaDetalleFacade.create(facdeta);
		
		//listproducto = ejbProductoFacade.findAll();
		faccabe.addFacturaDetalle(facdeta);
		
		
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
	
	public Usuario buscarPersonanombre() {
    
		System.out.println("recupero la person" + persona);
    	Usuario usu = new Usuario();
    	usu=ejbFacturaDetalleFacade.buscarpersona(persona);
    	System.out.println("Nombre es:" +usu);
    	
    	return usu;
    
    }
	
	public Producto getProd() {
		return prod;
	}

	public void setProd(Producto prod) {
		this.prod = prod;
	}

	
	public void calcularTotalParcial(){
		
		double valor=0 ;
		
		if(cantidad > 1) {
			
			valor = prod.getPreciounitario() * cantidad;
			System.out.println(valor);	
		}
	
	}  
	
	public void calcularIva() {
		
		double iva =0;
		
		if (subtotal != 0) {
			
			iva = 0.12 * subtotal;
			
			System.out.println("Subtotal mas Iva es:" + iva);
		}

	}
	
	public void calculartotalFinal() {
		
		double tot = 0;	
		tot = subtotal + iva;
		System.out.println("El total a pagar es: " + tot);
		
	}
	
	
	public void agregar() {
		
	
	
			
	}	
}

package ec.edu.ups.controlador;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.annotation.FacesConfig;
import javax.inject.Named;

import ec.edu.ups.ejb.BodegaFacade;
import ec.edu.ups.modelo.Bodega;
import ec.edu.ups.modelo.Ciudad;
import ec.edu.ups.modelo.Producto;
@FacesConfig(version = FacesConfig.Version.JSF_2_3)
@Named
@SessionScoped
public class BodegaBeans implements Serializable {
	private static final long serialVersionUID = 1L;
	@EJB
	private BodegaFacade ejbBodegaFacade;
	private List<Bodega> listaBdoega;
	private String nombre;
	private int stock;
	private List<Producto> listaproducto;
	//private Ciudad ciudad;
	private String pais;
	private String provincia;
	private String ciudad;
	private String producto;
	
	public BodegaBeans() {
		

	}

	@PostConstruct
	public void init() {		
		
	}
	public BodegaFacade getEjbBodegaFacade() {
		return ejbBodegaFacade;
	}
	public void setEjbBodegaFacade(BodegaFacade ejbBodegaFacade) {
		this.ejbBodegaFacade = ejbBodegaFacade;
	}
	public List<Bodega> getListaBdoega() {
		return listaBdoega;
	}
	public void setListaBdoega(List<Bodega> listaBdoega) {
		this.listaBdoega = listaBdoega;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}	
	public List<Producto> getListaproducto() {
		return listaproducto;
	}

	public void setListaproducto(List<Producto> listaproducto) {
		this.listaproducto = listaproducto;
	}

	public String getProducto() {
		return producto;
	}

	public void setProducto(String producto) {
		this.producto = producto;
	}

	public String getPais() {
		return pais;
	}
	public void setPais(String pais) {
		this.pais = pais;
	}
	public String getProvincia() {
		return provincia;
	}
	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}
	public String getCiudad() {
		return ciudad;
	}
	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}
	
	
	

}

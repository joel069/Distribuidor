package ec.edu.ups.controlador;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.annotation.FacesConfig;
import javax.faces.bean.SessionScoped;
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
	private Float preciounitario;
	private Float preciopublico;
	
	public ProductoBean() {
		
	}
	
	@PostConstruct
	public void init() {
		
	}
}

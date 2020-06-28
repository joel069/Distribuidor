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
import ec.edu.ups.modelo.Distribuidora;
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
	private List<Producto> producto;
	private Ciudad ciudad;
	private Distribuidora bodega;

	public BodegaBeans() {
		

	}



	@PostConstruct
	public void init() {		
		ejbBodegaFacade.create(new Bodega("J&J", 10, ciudad, bodega));
		listaBdoega = ejbBodegaFacade.findAll();
	}

}

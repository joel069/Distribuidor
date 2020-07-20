package ec.edu.ups.controlador;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.annotation.FacesConfig;
import javax.inject.Named;

@FacesConfig(version = FacesConfig.Version.JSF_2_3)
@Named
@SessionScoped
public class PedidoCabeceraBeans implements Serializable {


	

	private static final long serialVersionUID = 1L;
	@EJB private PedidoCabeceraBeans ejbCabeceraBeans;
	private String fecha;
	private double total;
	private String estadoPedido;
	

	public PedidoCabeceraBeans() {
		// TODO Auto-generated constructor stub
	}

}

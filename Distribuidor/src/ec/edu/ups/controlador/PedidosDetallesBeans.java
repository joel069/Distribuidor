package ec.edu.ups.controlador;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.annotation.FacesConfig;
import javax.inject.Named;

import ec.edu.ups.ejb.PedidoCabeceraFacade;
import ec.edu.ups.ejb.PedidosDetallesFacade;
import ec.edu.ups.modelo.PedidoDetalle;
import ec.edu.ups.modelo.PedidosCabecera;
import ec.edu.ups.modelo.Producto;

@FacesConfig(version = FacesConfig.Version.JSF_2_3)
@Named
@SessionScoped
public class PedidosDetallesBeans implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@EJB PedidosDetallesFacade ejbPedidosDetallesFacade;
	@EJB PedidoCabeceraFacade  ejbPedidoCabeceraFacade;
	
	
	private int cantidad;
	private double subtotalDetalle;
	private double total;
	private List<Producto> listProductos;
	private List<PedidoDetalle> listPedidosDetalles;
	private List<PedidosCabecera> listPeidodsCabeceras;
	

	public PedidosDetallesBeans() {
		// TODO Auto-generated constructor stub
	}
	
	@PostConstruct
	public void init() {
		listPedidosDetalles=ejbPedidosDetallesFacade.findAll();
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public double getSubtotalDetalle() {
		return subtotalDetalle;
	}

	public void setSubtotalDetalle(double subtotalDetalle) {
		this.subtotalDetalle = subtotalDetalle;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public List<Producto> getListProductos() {
		return listProductos;
	}

	public void setListProductos(List<Producto> listProductos) {
		this.listProductos = listProductos;
	}

	public List<PedidoDetalle> getListPedidosDetalles() {
		return listPedidosDetalles;
	}

	public void setListPedidosDetalles(List<PedidoDetalle> listPedidosDetalles) {
		this.listPedidosDetalles = listPedidosDetalles;
	}

	public List<PedidosCabecera> getListPeidodsCabeceras() {
		return listPeidodsCabeceras;
	}

	public void setListPeidodsCabeceras(List<PedidosCabecera> listPeidodsCabeceras) {
		this.listPeidodsCabeceras = listPeidodsCabeceras;
	}
	
//Metodos para agregar, listar, modificar y Eliminar
	
	public String remove(PedidoDetalle pd) {
		ejbPedidosDetallesFacade.remove(pd);
		listPedidosDetalles=ejbPedidosDetallesFacade.findAll();
		return null;
	}
	
	public String edit(PedidoDetalle pd) {
		pd.setEditable(true);
		return null;
	}
	
	public String save(PedidoDetalle pd) {
		ejbPedidosDetallesFacade.edit(pd);
		pd.setEditable(false);
		return null;
	}
	
	public String Facturar() {
		System.out.println("Se procede a facturar el pedido");
		return "funciona";
	}
}

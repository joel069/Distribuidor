package ec.edu.ups.modelo;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: PedidoDetalle
 *
 */
@Entity

public class PedidoDetalle implements Serializable {

	
	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
	private int cantidad;
	private double subtotalDetalle;
    @Transient
	private boolean editable;
    private double total;
    @ManyToOne
    private  PedidosCabecera pedidosCabID;
    @ManyToOne
    private Producto proid;
    
    
    
    
    

	public PedidoDetalle(int cantidad, double subtotalDetalle, double total,PedidosCabecera pedidosCabID, Producto proid) {
		super();
		this.cantidad = cantidad;
		this.subtotalDetalle = subtotalDetalle;
		this.total = total;
		this.pedidosCabID = pedidosCabID;
		this.proid = proid;
	}



	public PedidoDetalle() {
		super();
	}



	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
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



	public boolean isEditable() {
		return editable;
	}



	public void setEditable(boolean editable) {
		this.editable = editable;
	}



	public double getTotal() {
		return total;
	}



	public void setTotal(double total) {
		this.total = total;
	}



	public PedidosCabecera getPedidosCabID() {
		return pedidosCabID;
	}



	public void setPedidosCabID(PedidosCabecera pedidosCabID) {
		this.pedidosCabID = pedidosCabID;
	}



	public Producto getProid() {
		return proid;
	}



	public void setProid(Producto proid) {
		this.proid = proid;
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PedidoDetalle other = (PedidoDetalle) obj;
		if (id != other.id)
			return false;
		return true;
	}



	@Override
	public String toString() {
		return "PedidoDetalle [id=" + id + ", cantidad=" + cantidad + ", subtotalDetalle=" + subtotalDetalle + ", total=" + total + ", pedidosCabID=" + pedidosCabID + ", proid=" + proid
				+ "]";
	}
   
}

package ec.edu.ups.modelo;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: FacturaDetalle
 *
 */
@Entity

public class FacturaDetalle implements Serializable {

	
	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String cantidad;
    private double subtotal;
    private double total;
    private double descuento;
    @ManyToOne
    private FacturaCabecera facturadet;
    @ManyToOne
    private Producto producto;
   
	public FacturaDetalle() {
		
	}
	
	
	public FacturaDetalle(String cantidad, double subtotal, double total, double descuento,
			FacturaCabecera facturadet, Producto producto) {
		super();	
		this.cantidad = cantidad;
		this.subtotal = subtotal;
		this.total = total;
		this.descuento = descuento;
		this.facturadet = facturadet;
		this.producto = producto;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCantidad() {
		return cantidad;
	}

	public void setCantidad(String cantidad) {
		this.cantidad = cantidad;
	}

	public double getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(double subtotal) {
		this.subtotal = subtotal;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public double getDescuento() {
		return descuento;
	}

	public void setDescuento(double descuento) {
		this.descuento = descuento;
	}

	public FacturaCabecera getFacturadet() {
		return facturadet;
	}

	public void setFacturadet(FacturaCabecera facturadet) {
		this.facturadet = facturadet;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
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
		FacturaDetalle other = (FacturaDetalle) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "FacturaDetalle [id=" + id + ", cantidad=" + cantidad + ", subtotal=" + subtotal + ", total=" + total
				+ ", descuento=" + descuento + ", facturadet=" + facturadet + ", producto=" + producto + "]";
	}


		
   
}
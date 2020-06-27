package ec.edu.ups.modelo;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Distribuidora
 *
 */
@Entity

public class Bodega implements Serializable {

	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String nombre;
	private int stock;
	@OneToMany(mappedBy = "bodega")
	private List<Producto> producto;
	@ManyToOne
	private Distribuidora bodega;
	
	
	public Bodega() {
		super();
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
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


	public List<Producto> getProducto() {
		return producto;
	}


	public void setProducto(List<Producto> producto) {
		this.producto = producto;
	}


	public Distribuidora getBodega() {
		return bodega;
	}


	public void setBodega(Distribuidora bodega) {
		this.bodega = bodega;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((bodega == null) ? 0 : bodega.hashCode());
		result = prime * result + id;
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		result = prime * result + ((producto == null) ? 0 : producto.hashCode());
		result = prime * result + stock;
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
		Bodega other = (Bodega) obj;
		if (bodega == null) {
			if (other.bodega != null)
				return false;
		} else if (!bodega.equals(other.bodega))
			return false;
		if (id != other.id)
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		if (producto == null) {
			if (other.producto != null)
				return false;
		} else if (!producto.equals(other.producto))
			return false;
		if (stock != other.stock)
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "Bodega [id=" + id + ", nombre=" + nombre + ", stock=" + stock + ", producto=" + producto + ", bodega="
				+ bodega + "]";
	}
	
	

	
	
   
}

package ec.edu.ups.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
	@ManyToOne
	private Ciudad ciudad;
	@ManyToMany(cascade = CascadeType.MERGE)
	@JoinColumn
	private Collection<Producto> producto;
	@Transient
	private boolean editable;		
	
	public Bodega() {
		
	}
	

	public Bodega(String nombre, int stock, Ciudad ciudad) {
		super();
		this.nombre = nombre;
		this.stock = stock;
		this.ciudad = ciudad;			
	
	}


	public Ciudad getCiudad() {
		return ciudad;
	}


	public void setCiudad(Ciudad ciudad) {
		this.ciudad = ciudad;
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
		Bodega other = (Bodega) obj;
		if (id != other.id)
			return false;
		return true;
	}


	public boolean isEditable() {
		return editable;
	}


	public void setEditable(boolean editable) {
		this.editable = editable;
	}

	public void addProducto(Producto produ) {
		if (this.producto==null) {
			producto=new HashSet<Producto>();
		}
		this.producto.add(produ);
	}

	@Override
	public String toString() {
		return "Bodega [id=" + id + ", nombre=" + nombre + ", stock=" + stock + ", ciudad=" + ciudad + "]";
	}
	



	

	
	
   
}

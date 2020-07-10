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
	@ManyToOne
	private Ciudad ciudad;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "bodega")
	private Collection<Stock> listStock;
	@Transient
	private boolean editable;		
	
	public Bodega() {
		
	}
	

	public Collection<Stock> getListStock() {
		return listStock;
	}


	public void setListStock(Collection<Stock> listStock) {
		this.listStock = listStock;
	}


	public Bodega(String nombre, Ciudad ciudad) {
		super();
		this.nombre = nombre;
	
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


	@Override
	public String toString() {
		return nombre;
	}

	   
}

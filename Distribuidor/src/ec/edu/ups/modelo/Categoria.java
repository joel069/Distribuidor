package ec.edu.ups.modelo;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Categoria
 *
 */
@Entity

public class Categoria implements Serializable {

	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String nombre;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "categoria")
	private Set<Producto> usuarioRol = new HashSet<Producto>();
	

    
	
	public Categoria(int id, String nombre, Set<Producto> usuarioRol) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.usuarioRol = usuarioRol;
	}


	public Categoria() {
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


	public Set<Producto> getUsuarioRol() {
		return usuarioRol;
	}


	public void setUsuarioRol(Set<Producto> usuarioRol) {
		this.usuarioRol = usuarioRol;
	}


	@Override
	public int hashCode() {
		return  Objects.hash(id);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Categoria other = (Categoria) obj;
		if (id != other.id)
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "Categoria [id=" + id + ", nombre=" + nombre + ", usuarioRol=" + usuarioRol + "]";
	}
	
	
   
}

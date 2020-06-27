package ec.edu.ups.modelo;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Rol
 *
 */
@Entity

public class Rol implements Serializable {

	
	private static final long serialVersionUID = 1L;
	@Id
    private String nombre;
    private String descripcion;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "roles")
    Set<Usuario> usuarioRol = new HashSet<Usuario>();
    
	public Rol() {
		super();
	}

	
	public Rol(String nombre, String descripcion, Set<Usuario> usuarioRol) {
		super();
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.usuarioRol = usuarioRol;
	}


	

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Set<Usuario> getUsuarioRol() {
		return usuarioRol;
	}

	public void setUsuarioRol(Set<Usuario> usuarioRol) {
		this.usuarioRol = usuarioRol;
	}
	
	
	public boolean addUsuario(Usuario usuario) {
		return this.usuarioRol.add(usuario);
	}


	@Override
	public int hashCode() {
		return Objects.hash(nombre);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Rol other = (Rol) obj;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "Rol [nombre=" + nombre + ", descripcion=" + descripcion + ", usuarioRol=" + usuarioRol + "]";
	}

	

	
   
	
	
}

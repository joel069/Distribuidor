package ec.edu.ups.modelo;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Usuario
 *
 */
@Entity

public class Usuario extends Persona implements Serializable {

	
	private static final long serialVersionUID = 1L;
	private String correo;
	private String contraseña;
	@Transient
	private boolean editable;
	 @ManyToOne
	private Rol roles;
	 
	public Usuario() {
		super();
	}

	public Usuario(String nombre, String apellido, String telefono, String cedula, String correo, String contraseña,Rol roles) {
		super(nombre, apellido, telefono, cedula);
		this.correo = correo;
		this.contraseña = contraseña;
		this.roles=roles;
	}



	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getContraseña() {
		return contraseña;
	}

	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}

	public Rol getRoles() {
		return roles;
	}

	public void setRoles(Rol roles) {
		this.roles = roles;
	}


	

	public boolean isEditable() {
		return editable;
	}



	public void setEditable(boolean editable) {
		this.editable = editable;
	}



	//@Override
	//public String toString() {
	//	return "Usuario [correo=" + correo + ", contraseña=" + contraseña + ", roles=" + roles +"]";
	//}
	
	
	
	
   
	
}

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
	private String contrase�a;
	
	 @ManyToOne
	 private Rol roles;
	 
	public Usuario() {
		super();
	}
	
	

	public Usuario(String correo, String contrase�a, Rol roles) {
		super();
		this.correo = correo;
		this.contrase�a = contrase�a;
		this.roles = roles;
	}


	

	
	public Usuario(String nombre, String apellido, String telefono, String cedula, String correo, String contrase�a,
			Rol roles) {
		super(nombre, apellido, telefono, cedula);
		this.correo = correo;
		this.contrase�a = contrase�a;
		this.roles = roles;
	}



	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getContrase�a() {
		return contrase�a;
	}

	public void setContrase�a(String contrase�a) {
		this.contrase�a = contrase�a;
	}

	public Rol getRoles() {
		return roles;
	}

	public void setRoles(Rol roles) {
		this.roles = roles;
	}


	

	@Override
	public String toString() {
		return "Usuario [correo=" + correo + ", contrase�a=" + contrase�a + ", roles=" + roles + "]";
	}
	
	
   
	
}
package ec.edu.ups.controlador;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.annotation.FacesConfig;
import javax.inject.Named;

import ec.edu.ups.ejb.UsuarioFacade;
import ec.edu.ups.modelo.Rol;
import ec.edu.ups.modelo.Usuario;

@FacesConfig(version = FacesConfig.Version.JSF_2_3)
@Named
@SessionScoped
public class UsuarioBean implements Serializable{
	@EJB
	private UsuarioFacade ejbUsuarioFacade;
	private Rol ejbRolFacade;
	private List<Usuario> list;
	private Rol rol;
	private String nombre;
	private String apellido;
	private String telefono;
	private String cedula;
	private String correo;
	private String contraseña;
	
	public UsuarioBean() {
		rol=new Rol();
	}
	
	@PostConstruct
	public void init() {
		 list= ejbUsuarioFacade.findAll();
	 }

	public Usuario[] getList() {
		return list.toArray(new Usuario[0]);
	}

	public void setList(List<Usuario> list) {
		this.list = list;
	}
	 
	 public String add() {
		 ejbUsuarioFacade.create(new Usuario(this.nombre,this.apellido,this.telefono,this.cedula,this.correo,this.contraseña,this.rol));
			list = ejbUsuarioFacade.findAll();
			return null;
		    }

		    public String delete(Usuario c) {	
		    	ejbUsuarioFacade.remove(c);
			list = ejbUsuarioFacade.findAll();
			return null;
		    }

		    
		    //para que se muestren los editables del proyecto (input) para editar
		    public String edit(Usuario c) {
			c.setEditable(true);
			return null;
		    }

		    public String save(Usuario c) {
		    	ejbUsuarioFacade.edit(c);
			c.setEditable(false);
			return null;
		    }

			public Rol getRol() {
				return rol;
			}

			public void setRol(Rol rol) {
				this.rol = rol;
			}

			public String getNombre() {
				return nombre;
			}

			public void setNombre(String nombre) {
				this.nombre = nombre;
			}

			public String getApellido() {
				return apellido;
			}

			public void setApellido(String apellido) {
				this.apellido = apellido;
			}

			public String getTelefono() {
				return telefono;
			}

			public void setTelefono(String telefono) {
				this.telefono = telefono;
			}

			public String getCedula() {
				return cedula;
			}

			public void setCedula(String cedula) {
				this.cedula = cedula;
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

  
	
}

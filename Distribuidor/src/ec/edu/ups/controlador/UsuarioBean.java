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
		ejbUsuarioFacade.create(new Usuario("Ernesto","Piedra","0992726928","0151489813","ernesto@gmail.com","123",rol));
		 list= ejbUsuarioFacade.findAll();
	 }

	public Rol[] getList() {
		return list.toArray(new Rol[0]);
	}

	public void setList(List<Usuario> list) {
		this.list = list;
	}
	 
	 public String add() {
		 ejbUsuarioFacade.create(new Usuario(this.nombre,this.apellido,this.telefono,this.cedula,this.correo,this.contraseña,this.rol	));
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

  
	
}

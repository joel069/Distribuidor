package ec.edu.ups.controlador;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.annotation.FacesConfig;
import javax.inject.Named;

import ec.edu.ups.ejb.PersonaFacade;
import ec.edu.ups.modelo.Persona;

@FacesConfig(version = FacesConfig.Version.JSF_2_3)
@Named
@SessionScoped
public class PersonaBean implements Serializable{
	@EJB
	private PersonaFacade ejbPersonaFacade;
	private List<Persona> list;
    private String nombre;
    private String apellido;
    private String telefono;
    private String cedula;
    
	public PersonaBean() {
		
	}
	
	 @PostConstruct
	    public void init() {
		list = ejbPersonaFacade.findAll();
	    }
	        
	    public Persona[] getList() {
		return list.toArray(new Persona[0]);
	    }

	    public void setList(List<Persona> list) {
		this.list = list;
	    }

	    public String add() {
	    ejbPersonaFacade.create(new Persona(this.nombre,this.apellido,this.telefono,this.cedula));
		list = ejbPersonaFacade.findAll();
		return null;
	    }

	    public String delete(Persona c) {	
	    	ejbPersonaFacade.remove(c);
		list = ejbPersonaFacade.findAll();
		return null;
	    }

	    
	    //para que se muestren los editables del proyecto (input) para editar
	    public String edit(Persona c) {
		c.setEditable(true);
		return null;
	    }

	    public String save(Persona c) {
	    	ejbPersonaFacade.edit(c);
		c.setEditable(false);
		return null;
	    }

	
}

package ec.edu.ups.controlador;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.annotation.FacesConfig;
import javax.inject.Named;

import ec.edu.ups.ejb.RolFacade;
import ec.edu.ups.ejb.UsuarioFacade;
import ec.edu.ups.modelo.Categoria;
import ec.edu.ups.modelo.Rol;
import ec.edu.ups.modelo.Usuario;

@FacesConfig(version = FacesConfig.Version.JSF_2_3)
@Named
@SessionScoped
public class UsuarioBean implements Serializable{
	@EJB
	private UsuarioFacade ejbUsuarioFacade;
	private RolFacade ejbRolFacade;
	private List<Usuario> list;
	private Rol rol;
	private String nombre;
	private String apellido;
	private String telefono;
	private String cedula;
	private String correo;
	private String contrasena;
	private String direccion;
	private Rol roll;
	private String rool;
	private String corr;
	private String contra;
	
	public UsuarioBean() {
		
	}
	
	@PostConstruct
	public void init() {
		 
		 //ejbUsuarioFacade.create(new Usuario("Kevin","Cordero","0992726928","015128912","kevin@gmail.com","123",rol));
		 list= ejbUsuarioFacade.findAll();
	 }

	public Usuario[] getList() {
		return list.toArray(new Usuario[0]);
	}

	public void setList(List<Usuario> list) {
		this.list = list;
	}
	 
	 public String add() {
		 ejbUsuarioFacade.create(new Usuario(this.nombre,this.apellido,this.telefono,this.cedula,this.correo,this.contrasena,buscar()));
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

			public String getContrasena() {
				return contrasena;
			}

			public void setContrasena(String contrasena) {
				this.contrasena = contrasena;
			}

			public String getDireccion() {
				return direccion;
			}

			public void setDireccion(String direccion) {
				this.direccion = direccion;
			}

			public String getRool() {
				return rool;
			}

			public void setRool(String rool) {
				this.rool = rool;
			}

  
			public String getCorr() {
				return corr;
			}

			public void setCorr(String corr) {
				this.corr = corr;
			}

			public String getContra() {
				return contra;
			}

			public void setContra(String contra) {
				this.contra = contra;
			}

			public Rol buscar() {
				Rol rol = new Rol();
				System.out.println("Se recupera elrol------------------------------------>>>>>>");
				System.out.println(rool);
				System.out.println("---------------------------------------");
			rol= ejbUsuarioFacade.buscarRol(rool);
			System.out.println("muestra del rol");
			System.out.println(rol);
			return rol;
			}
			
			
			
			public String inicio() {
				try {
				Usuario us = new Usuario();
				System.out.println("cREDENCIALES");
				System.out.println(corr);
				System.out.println(contra);
				us = ejbUsuarioFacade.inicio(corr, contra);
				System.out.println("El usuario ingresadooooooo");
				System.out.println(us);
				Rol rol1=new Rol();
				rol1.setNombre("administrador");
				Usuario usu=new Usuario();
				usu.setRoles(rol1);
				
				Rol rol2=new Rol();
				rol2.setNombre("empleado");
				Usuario usu1=new Usuario();
				usu.setRoles(rol2);
				
				System.out.println(us.getRoles().equals(rol1));
					if (us != null && us.getRoles().equals(rol1)) {
						return "exito";
					} else if(us != null && us.getRoles().equals(rol2)) {
						return "exitoEmple";
					} else {
						return "fallo";
					}
				} catch (Exception e) {
					return "fallo";
				}
                 
			}
			
	
}

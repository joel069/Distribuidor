package ec.edu.ups.ejb;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import ec.edu.ups.modelo.Rol;
import ec.edu.ups.modelo.Usuario;
@Stateless
public class UsuarioFacade extends AbstractFacade<Usuario>{

	@PersistenceContext(unitName = "Distribuidor")
	private EntityManager em;
	

	public UsuarioFacade() {
		super(Usuario.class);
	}

	@Override
	protected EntityManager getEntityManager() {
		// TODO Auto-generated method stub
		return em;
	}
	
	public Rol buscarRol(String nombre){
		Rol rol=new Rol();
		String sql="SELECT p FROM Rol p where p.nombre='"+nombre+"'";
		rol = (Rol) em.createQuery(sql).getSingleResult();
		return rol;
	}
	
	public Usuario inicio(String username, String password) {
    	Usuario us=new Usuario();
   	 String query = "SELECT e " +
   		      "FROM Usuario e " +
   		      "WHERE e.correo = '" + username +
   		      "' AND " +
   		      " e.contraseña = '" + password + "'";
      	us =em.createQuery(query, Usuario.class).getSingleResult();
   		      return us;
   }

	public List<Usuario> muestraClientes() {
		String sql="SELECT u FROM Usuario u where u.roles.nombre = 'cliente'";
		List<Usuario> list = em.createQuery(sql).getResultList();
		System.out.println("Lista persona:" + list);
		return list;
   }

}

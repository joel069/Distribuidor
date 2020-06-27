package ec.edu.ups.ejb;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import ec.edu.ups.modelo.Rol;
import ec.edu.ups.modelo.Usuario;

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
}

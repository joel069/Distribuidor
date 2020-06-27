package ec.edu.ups.ejb;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import ec.edu.ups.modelo.Provincia;
import ec.edu.ups.modelo.Rol;

public class RolFacade extends AbstractFacade<Rol> {

	@PersistenceContext(unitName = "Distribuidor")
	private EntityManager em;
	

	public RolFacade() {
		super(Rol.class);
	}

	@Override
	protected EntityManager getEntityManager() {
		// TODO Auto-generated method stub
		return em;
	}
	
}

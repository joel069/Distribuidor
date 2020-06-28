package ec.edu.ups.ejb;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import ec.edu.ups.modelo.Ciudad;
@Stateless
public class CiudadFacade extends AbstractFacade<Ciudad> {

	@PersistenceContext(unitName = "Distribuidor")
	private EntityManager em;
	public CiudadFacade() {
		super(Ciudad.class);
	}

	@Override
	protected EntityManager getEntityManager() {
		// TODO Auto-generated method stub
		return em;
	}

}

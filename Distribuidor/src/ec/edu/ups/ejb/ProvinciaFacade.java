package ec.edu.ups.ejb;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import ec.edu.ups.modelo.Provincia;

public class ProvinciaFacade extends AbstractFacade<Provincia> {
	
	@PersistenceContext(unitName = "Distribuidor")
	private EntityManager em;
	

	public ProvinciaFacade() {
		super(Provincia.class);
	}

	@Override
	protected EntityManager getEntityManager() {
		// TODO Auto-generated method stub
		return em;
	}

}

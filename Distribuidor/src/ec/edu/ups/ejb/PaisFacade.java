package ec.edu.ups.ejb;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import ec.edu.ups.modelo.Pais;

public class PaisFacade  extends AbstractFacade<Pais>{
	
	@PersistenceContext(unitName = "Distribuidor")
	private EntityManager em;
	
	public PaisFacade() {
		super(Pais.class);
	}

	@Override
	protected EntityManager getEntityManager() {
		// TODO Auto-generated method stub
		return em;
	}


}

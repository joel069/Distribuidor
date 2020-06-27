package ec.edu.ups.ejb;

import ec.edu.ups.modelo.Bodega;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class BodegaFacade extends AbstractFacade<Bodega>{

	@PersistenceContext(unitName = "Distribuidor")
    private EntityManager em;
    
    public BodegaFacade() {
	super(Bodega.class);
    }    

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
}

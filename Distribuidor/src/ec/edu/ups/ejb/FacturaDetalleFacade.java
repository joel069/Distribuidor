package ec.edu.ups.ejb;

import javax.persistence.EntityManager;

import javax.persistence.PersistenceContext;

import ec.edu.ups.modelo.FacturaDetalle;




public class FacturaDetalleFacade extends AbstractFacade<FacturaDetalle> {
	@PersistenceContext(unitName = "Distribuidor")
    private EntityManager em;
    
    public FacturaDetalleFacade() {
	super(FacturaDetalle.class);
    }    

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
}

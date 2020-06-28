package ec.edu.ups.ejb;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;

import javax.persistence.PersistenceContext;

import ec.edu.ups.modelo.FacturaCabecera;

@Stateless
public class FacturaCabeceraFacade extends AbstractFacade<FacturaCabecera>{
	@PersistenceContext(unitName = "Distribuidor")
    private EntityManager em;
    
    public FacturaCabeceraFacade() {
	super(FacturaCabecera.class);
    }    

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
}

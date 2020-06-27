package ec.edu.ups.ejb;

import javax.persistence.EntityManager;

import javax.persistence.PersistenceContext;

import ec.edu.ups.modelo.Persona;


public class PersonaFacade extends AbstractFacade<Persona>{
	@PersistenceContext(unitName = "Distribuidor")
    private EntityManager em;
    
    public PersonaFacade() {
	super(Persona.class);
    }    
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
}

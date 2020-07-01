package ec.edu.ups.ejb;

import ec.edu.ups.modelo.Bodega;
import ec.edu.ups.modelo.Categoria;
import ec.edu.ups.modelo.Ciudad;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
@Stateless
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
    
    public Ciudad validar(String ciudad ) {
		Ciudad cat=new Ciudad();
		try {
			String sql="SELECT c FROM Ciudad c where c.nombre='"+ciudad+"'";
			System.out.println(sql);
			Query query = em.createQuery(sql);
			cat= (Ciudad) query.getSingleResult();
			System.out.println("recupere"+ciudad);	
		} catch (Exception e) {
			System.out.println("ciudad"+e.getMessage());
		}
			
		return cat;
		
	}
    
    public Bodega nombreBodega(String bodega ) {
  		Bodega cat=new Bodega();
  		try {
  			String sql="SELECT b FROM Bodega b where b.nombre='"+bodega+"'";
  			System.out.println(sql);
  			Query query = em.createQuery(sql);
  			cat= (Bodega) query.getSingleResult();
  				
  		} catch (Exception e) {
  			System.out.println("bodega"+e.getMessage());
  		}
  			
  		return cat;
  		
  	}
}

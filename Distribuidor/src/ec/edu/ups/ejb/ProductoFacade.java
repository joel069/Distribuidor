package ec.edu.ups.ejb;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import ec.edu.ups.modelo.Categoria;
import ec.edu.ups.modelo.Pais;
import ec.edu.ups.modelo.Producto;
@Stateless
public class ProductoFacade extends AbstractFacade<Producto>{
	
	 @PersistenceContext(unitName = "Distribuidor")
	    private EntityManager em;
	    
	    public ProductoFacade() {
		super(Producto.class);
	    }    

	    @Override
	    protected EntityManager getEntityManager() {
	        return em;
	    }
	    
		public Categoria validar(String categoria ) {
			Categoria cat=new Categoria();
			try {
				String sql="SELECT c FROM Categoria c where c.nombre='"+categoria+"'";
				System.out.println(sql);
				Query query = em.createQuery(sql);
				cat= (Categoria) query.getSingleResult();
				System.out.println("recupere"+categoria);	
			} catch (Exception e) {
				System.out.println("Pais"+e.getMessage());
			}
				
			return cat;
		
		}
}

package ec.edu.ups.ejb;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;

import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import ec.edu.ups.modelo.Categoria;
import ec.edu.ups.modelo.FacturaDetalle;
import ec.edu.ups.modelo.Producto;



@Stateless
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
   
	
	public Producto buscarProductos(String nombre){
		Producto p = new Producto();
		
		try {
		
		String sql="SELECT p FROM Producto p where p.nombre='"+nombre+"'";
		Query qu = em.createQuery(sql);
		p =(Producto) qu.getSingleResult();
		System.out.println("recupero" + nombre);
		}catch(Exception e) {
			System.out.println("Pais"+e.getMessage());
		}
		return p;
	}
}

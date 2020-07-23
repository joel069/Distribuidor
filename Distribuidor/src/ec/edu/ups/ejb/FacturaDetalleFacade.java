package ec.edu.ups.ejb;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;

import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import ec.edu.ups.modelo.Categoria;
import ec.edu.ups.modelo.FacturaDetalle;
import ec.edu.ups.modelo.Producto;
import ec.edu.ups.modelo.Usuario;

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
		System.out.println("El nombre que llega a las base es" +nombre);
		Producto pro = new Producto();
		try {
		String sql = "SELECT u FROM Producto u where u.nombre= '"+nombre+"'";
		System.out.println(sql);
		Query query = em.createQuery(sql);
		pro= (Producto) query.getSingleResult();
		System.out.println("recupere : " +nombre);
	}catch(Exception e) {
		System.out.println("Usuario" + e.getMessage());
	}
		return pro;
	}
	
	public Usuario buscarpersona(String nombre) {
		System.out.println("El nombre que llega a las base es" +nombre);
		Usuario usu = new Usuario();
		try {
		String sql = "SELECT u FROM Usuario u where u.nombre= '"+nombre+"'";
		System.out.println(sql);
		Query query = em.createQuery(sql);
		usu= (Usuario) query.getSingleResult();
		System.out.println("recupere : " +nombre);
	}catch(Exception e) {
		System.out.println("Producto" + e.getMessage());
	}
		
		return usu;
 }
}

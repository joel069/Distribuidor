package ec.edu.ups.ejb;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import ec.edu.ups.modelo.Pais;
import ec.edu.ups.modelo.PedidoDetalle;
import ec.edu.ups.modelo.Provincia;
import ec.edu.ups.modelo.Stock;
import ec.edu.ups.modelo.Usuario;

@Stateless
public class PedidosDetallesFacade  extends AbstractFacade<PedidoDetalle>{
	@PersistenceContext(unitName = "Distribuidor")
    private EntityManager em;

	public PedidosDetallesFacade() {
		// TODO Auto-generated constructor stub
		super(PedidoDetalle.class);
	}

	@Override
	protected EntityManager getEntityManager() {
		// TODO Auto-generated method stub
		return em;
	}
	
	public List<PedidoDetalle> pedidosDetalle(Usuario usuario) {
		System.out.println("Correo llegada");
System.out.println(usuario);
		String sql = "SELECT p FROM PedidoDetalle p where  p.pedidosCabID.cliente.nombre='"+usuario.getNombre()+"'";
		System.out.println(sql);
		List<PedidoDetalle> list = em.createQuery(sql).getResultList();
		for (PedidoDetalle stock : list) {
			System.out.println("Nombre  Cliente"+stock.getPedidosCabID().getCliente().getNombre());
			System.out.println("fecha Cab"+stock.getPedidosCabID().getFecha());
			System.out.println("Total cab"+stock.getPedidosCabID().getTotal());
			System.out.println("Cantidades de prod detalle"+stock.getProid().toString());
			System.out.println("Subtotal detalle pedido"+stock.getSubtotalDetalle());
			System.out.println("Cantidad productos"+stock.getCantidad());
		}		
		System.out.println("recuperooooooooooo");
		System.out.println(list);
		return list;

	}


}

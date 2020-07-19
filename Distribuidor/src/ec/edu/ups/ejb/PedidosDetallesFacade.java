package ec.edu.ups.ejb;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import ec.edu.ups.modelo.PedidoDetalle;

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

}

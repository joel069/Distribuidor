package ec.edu.ups.controlador;

import ec.edu.ups.ejb.PaisFacade;
import ec.edu.ups.ejb.ProductoFacade;
import ec.edu.ups.ejb.ProvinciaFacade;
import ec.edu.ups.modelo.Pais;
import ec.edu.ups.modelo.Producto;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PaisBean bo= new PaisBean();

		ProductoFacade pais= new ProductoFacade();
		Producto pa=pais.find(1);
		System.out.println(pa);
	
		
	
	}

}

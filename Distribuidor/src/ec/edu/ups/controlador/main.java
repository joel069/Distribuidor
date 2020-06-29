package ec.edu.ups.controlador;

import ec.edu.ups.ejb.PaisFacade;
import ec.edu.ups.ejb.ProvinciaFacade;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PaisBean bo= new PaisBean();

		ProvinciaFacade pais= new ProvinciaFacade();
		pais.validar("Ecuador");
	
	
	
	
	}

}

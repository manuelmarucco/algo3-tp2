package construcciones.terran;

import fiuba.algo3.algocraft.unidades.Vida;
import auxiliares.Costo;


public class Fabrica extends ConstruccionTerran{
	
	//necesita que la Barraca haya sido construida para poder crearse
	
	public Fabrica(){
		nombre = "Fabrica";
		vida = new Vida(200);
		costo = new Costo(150,100);
	}
	
}

package construcciones.terran;

import fiuba.algo3.algocraft.unidades.Vida;


public class PuertoEstelar extends ConstruccionTerran{

	//necesita que la Fabrica haya sido construida para poder crearse
	
		public PuertoEstelar(){
			nombre = "PuertoEstelar";
			vida = new Vida(250);
		}
	
}

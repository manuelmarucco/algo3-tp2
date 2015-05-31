package construcciones.terran;

import fiuba.algo3.algocraft.unidades.Vida;
import auxiliares.Costo;


public class CentroDeMineral extends ConstruccionTerran {
	
	private final int mineralRecolectado = 10; //por turno
	
	public CentroDeMineral(){
		vida = new Vida(150);
		costo = new Costo(50,0);
	}
	
	// esta funcion la debe llamar alguna clase en cada turno y debe modificar el atributo de la instancia Jugador
	//  |
	//  |
	//  v
	public int getMineralRecolectado(){
		return mineralRecolectado;
	}

	
}

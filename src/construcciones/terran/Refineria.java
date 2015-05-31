package construcciones.terran;

import fiuba.algo3.algocraft.unidades.Vida;


public class Refineria extends ConstruccionTerran {
	
	private final int gasRecolectado = 10; //por turno
	
	public Refineria(){
		vida = new Vida(150);
	}
	
	// esta funcion la debe llamar el Jugador en cada turno
	//  |
	//  |
	//  v
	public int getGasRecolectado(){
		return gasRecolectado;
	}
	
}

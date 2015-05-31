package construcciones.protoss;

import fiuba.algo3.algocraft.unidades.VidaEscudo;


public class Asimilador extends ConstruccionProtoss{
	
	private final int gasRecolectado = 10; //por turno
	
	public Asimilador(){
		vidaEscudo = new VidaEscudo(150,50);
	}
	
	// esta funcion la debe llamar el Jugador u otr clase en cada turno
	//  |
	//  |
	//  v
	public int getGasRecolectado(){
		return gasRecolectado;
	}
	
}

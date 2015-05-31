package construcciones.protoss;

import fiuba.algo3.algocraft.unidades.VidaEscudo;


public class Pilon extends ConstruccionProtoss{
	
	private final int capacidadExtra = 5;
	
	public Pilon(){
		vidaEscudo = new VidaEscudo(200,50);
	}
	
	public int getCapacidadExtra(){
		return capacidadExtra;
	}
}

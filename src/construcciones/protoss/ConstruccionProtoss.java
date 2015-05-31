package construcciones.protoss;

import construcciones.Construccion;
import fiuba.algo3.algocraft.unidades.VidaEscudo;

public abstract class ConstruccionProtoss extends Construccion{
	
	protected  VidaEscudo vidaEscudo;
	
	public int getVida() {
		return vidaEscudo.getVidaActual();
	}
	
	public int getEscudo() {
		return vidaEscudo.getEscudoActual();
	}
	
	@Override
	public void recibirDanio(int danioParcial){
		 vidaEscudo.quitar(danioParcial);
	}
	
}

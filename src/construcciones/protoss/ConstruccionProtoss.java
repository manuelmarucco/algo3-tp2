package construcciones.protoss;

import construcciones.Construccion;
import fiuba.algo3.algocraft.comandos.Accion;
import fiuba.algo3.algocraft.comandos.Regenerar;
import fiuba.algo3.algocraft.unidades.VidaEscudo;

public abstract class ConstruccionProtoss extends Construccion{
	
	protected  VidaEscudo vidaEscudo;

	public ConstruccionProtoss(){
		this.poolDeAcciones.put(Accion.REGENERAR,new Regenerar());
	}

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

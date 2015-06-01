package construcciones.protoss;

import construcciones.Construccion;
import fiuba.algo3.algocraft.comandos.Accion;
import fiuba.algo3.algocraft.comandos.Regenerar;
import fiuba.algo3.algocraft.unidades.parametros.Danio;
import fiuba.algo3.algocraft.unidades.parametros.Vida;
import fiuba.algo3.algocraft.unidades.parametros.VidaEscudo;
import interfaces.Actuable;

import java.util.HashMap;

public abstract class ConstruccionProtoss extends Construccion{
	
	protected  VidaEscudo vidaEscudo;

	public ConstruccionProtoss(){
		this.poolDeAcciones= new HashMap<Accion, Actuable>();
		this.poolDeAcciones.put(Accion.REGENERAR,new Regenerar());
	}

	public Vida getVida() {
		return vidaEscudo;
	}
	
	public int getEscudo() {
		return vidaEscudo.getEscudoActual();
	}

	public void recibirDanio(Danio danio){
		vidaEscudo.quitar(danio.getTierra());
	}
}

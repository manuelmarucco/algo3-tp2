package construcciones.terran;

import construcciones.Construccion;
import fiuba.algo3.algocraft.comandos.Accion;
import fiuba.algo3.algocraft.unidades.parametros.Danio;
import fiuba.algo3.algocraft.unidades.parametros.Vida;
import interfaces.Actuable;

import java.util.HashMap;

public abstract class ConstruccionTerran extends Construccion{

	protected Vida vida;

	public ConstruccionTerran(){
		this.poolDeAcciones= new HashMap<Accion, Actuable>();
	}

	public Vida getVida(){
		return vida;
	}
	
	@Override
	public void recibirDanio(Danio danio){
		vida.quitar(danio.getTierra());//TODO:si las unidades se vuelven aereas hay q cambiar esto
	}

		
}

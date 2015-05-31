package construcciones.terran;

import construcciones.Construccion;
import fiuba.algo3.algocraft.unidades.Vida;

public abstract class ConstruccionTerran extends Construccion{

	protected Vida vida;
	
	public Vida getVida(){
		return vida;
	}
	
	@Override
	public void recibirDanio(int danioParcial){
	        
		vida.quitar(danioParcial);
	        	
	}

		
}

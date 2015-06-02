package razas.terran.construcciones;

import manejoDeConstrucciones.Construccion;
import manejoDeUnidades.Vida;

public abstract class ConstruccionTerran extends Construccion{

	protected Vida vida;
	
	public int getVida(){
		return vida.getVidaActual();
	}
	
	@Override
	public void recibirDanio(int danioParcial){
	        
		vida.quitar(danioParcial);
	        	
	}

		
}

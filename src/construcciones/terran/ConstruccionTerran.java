package construcciones.terran;

import construcciones.Construccion;

public abstract class ConstruccionTerran extends Construccion{

	protected int vida;
	
	public int getVida(){
		return vida;
	}
	
	@Override
	public void recibirDanio(int danioParcial){
	        
	        	vida = Math.max(vida-danioParcial,0);
	        	
	}

		
}

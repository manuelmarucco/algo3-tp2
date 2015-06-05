package construcciones.terran;

import unidades.Vida;
import construcciones.Construccion;

public abstract class ConstruccionTerran extends Construccion{

	protected Vida vida;
	
	public int getVida(){
		return vida.getVidaActual();
	}
	
	@Override
	public void recibirDanio(int danioParcial){
	        
		vida.quitar(danioParcial);
	        	
	}
	
	public boolean habilitaAConstruir(Fabrica p) {
		return false;
	}
	public boolean habilitaAConstruir(PuertoEstelar p) {
		return false;
	}
	
	public void update(){
		tiempoDeConstruccion--;
	}
		
}

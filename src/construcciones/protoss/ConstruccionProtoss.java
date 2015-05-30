package construcciones.protoss;

import construcciones.Construccion;
import interfaces.Recargable;

public abstract class ConstruccionProtoss extends Construccion implements Recargable{
	
	protected int vida;
	protected int escudo;
	
	public void recargarEscudo(){	//llamar a este metodo una vez por turno
		escudo = escudo + 3;
	}
	
	public int getVida() {
		return vida;
	}
	
	public int getEscudo() {
		return escudo;
	}
	
	public void recibirDanio(int danioParcial){
		 int danioALaVida= danioParcial-this.escudo;
	        
	        if (danioALaVida>0){
	            escudo=0;
	            vida -= danioALaVida; 
	        }else
	        	escudo-=danioParcial;
	}
	
}

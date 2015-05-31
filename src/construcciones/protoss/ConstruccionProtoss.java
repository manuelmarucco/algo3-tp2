package construcciones.protoss;

import construcciones.Construccion;

public abstract class ConstruccionProtoss extends Construccion{
	
	protected int vida;
	protected int escudo;
	
	public void regenerar(){	//llamar a este metodo una vez por turno
		escudo = escudo + 3;
	}
	
	public int getVida() {
		return vida;
	}
	
	public int getEscudo() {
		return escudo;
	}
	
	@Override
	public void recibirDanio(int danioParcial){
		 int danioALaVida= danioParcial-this.escudo;
	        
	        if (danioALaVida>0){
	            escudo=0;
	            vida -= danioALaVida; 
	        }else
	        	escudo-=danioParcial;
	}
	
}

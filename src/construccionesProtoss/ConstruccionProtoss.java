package construccionesProtoss;

import interfaces.Construible;
import interfaces.Recargable;

public abstract class ConstruccionProtoss implements Recargable, Construible{
	
	protected int vida;
	protected int escudo;
	
	public void recargarEscudo(){	//llamar a este metodo una vez por turno
		escudo = escudo + 1;
	}
	
	public int getVida() {
		return vida;
	}
	
	public int getEscudo() {
		return escudo;
	}
	
	
	
}

	package construcciones.protoss;

import unidades.Escudo;
import construcciones.Construccion;
import unidades.Vida;

	public abstract class ConstruccionProtoss extends Construccion{
	
	protected Escudo escudo;

	public ConstruccionProtoss(int vida,int escudo){
		this.escudo= new Escudo(escudo);
		this.vida = new Vida(vida);
	}
	
	public int getVida() {
		return vida.getVidaActual();
	}
	
	public int getEscudo() {
		return escudo.getEscudoActual();
	}
	
	@Override
	public void recibirDanio(int danioParcial){
		 vida.quitar(escudo.quitar(danioParcial));
	}

	public void update(){
		this.escudo.regenerar();
	}
	
}

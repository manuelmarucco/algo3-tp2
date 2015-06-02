package construcciones.protoss;

import auxiliares.Costo;
import jugabilidad.Mapa;
import jugabilidad.utilidadesMapa.Coordenadas;
import fiuba.algo3.algocraft.unidades.VidaEscudo;


public class Pilon extends ConstruccionProtoss{
	
	private final int capacidadExtra = 5;
	private int poblacionMaxima;
	
	public Pilon(int pobMax){
		vidaEscudo = new VidaEscudo(300,300);
		costo = new Costo(100,0);
		tiempoDeConstruccion = 5;
		poblacionMaxima = pobMax;
	}
	
	public int getCapacidadExtra(){
		return capacidadExtra;
	}

	@Override
	public void agregarse(Mapa mapa, Coordenadas coordenadas) {
		
		mapa.agregarEnTierra(this, coordenadas);
		
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

}

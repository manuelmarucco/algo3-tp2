package construcciones.protoss;

import jugabilidad.Mapa;
import jugabilidad.utilidadesMapa.Coordenadas;
import fiuba.algo3.algocraft.unidades.VidaEscudo;


public class NexoMineral extends ConstruccionProtoss{

	private final int mineralRecolectado = 10; //por turno
	
	public NexoMineral(){
		vidaEscudo = new VidaEscudo(150,50);
	}
	
	// esta funcion la debe llamar alguna clase en cada turno y debe modificar el atributo de la instancia Jugador
	//  |
	//  |
	//  v
	public int getMineralRecolectado(){
		return mineralRecolectado;
	}
	
	@Override
	public void agregarse(Mapa mapa, Coordenadas coordenadas) {
		
		mapa.agregarEnTierra(this, coordenadas);
		
	}
}

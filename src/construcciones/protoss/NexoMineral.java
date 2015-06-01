package construcciones.protoss;

import auxiliares.Costo;
import jugabilidad.Mapa;
import jugabilidad.utilidadesMapa.Coordenadas;
import fiuba.algo3.algocraft.unidades.VidaEscudo;


public class NexoMineral extends ConstruccionProtoss{

	private final int mineralRecolectado = 10; //por turno
	
	public NexoMineral(){
		nombre = "NexoMineral";
		vidaEscudo = new VidaEscudo(250,250);
		costo = new Costo(50,0);
		tiempoDeConstruccion = 4;
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

package construcciones.protoss;

import auxiliares.Costo;
import auxiliares.Recursos;
import jugabilidad.Mapa;
import jugabilidad.utilidadesMapa.Coordenadas;
import fiuba.algo3.algocraft.unidades.VidaEscudo;


public class NexoMineral extends ConstruccionProtoss{

	private final int mineralesRecolectados = 10; //por turno
	private Recursos recursosDeJugador;
	
	public NexoMineral(){}
	public NexoMineral(Recursos recursos){
		nombre = "NexoMineral";
		vidaEscudo = new VidaEscudo(250,250);
		costo = new Costo(50,0);
		tiempoDeConstruccion = 4;
		recursosDeJugador = recursos;
	}
	
	@Override
	public void agregarse(Mapa mapa, Coordenadas coordenadas) {
		
		mapa.agregarEnTierra(this, coordenadas);
		
	}

	@Override
	public void update() {
		recursosDeJugador.agregarRecursos(mineralesRecolectados, 0);
		
	}
	

}

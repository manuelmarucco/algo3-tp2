package construcciones.protoss;

import auxiliares.Costo;
import auxiliares.Recursos;
import jugabilidad.Mapa;
import jugabilidad.utilidadesMapa.Coordenadas;
import fiuba.algo3.algocraft.unidades.VidaEscudo;


public class Asimilador extends ConstruccionProtoss{
	
	private final int gasRecolectado = 10; //por turno
	private Recursos recursosDeJugador;
	
	public Asimilador(Recursos recursos){
		vidaEscudo = new VidaEscudo(450,450);
		costo = new Costo(100,0);
		tiempoDeConstruccion = 6;
		recursosDeJugador = recursos;
	}
	

	@Override
	public void agregarse(Mapa mapa, Coordenadas coordenadas) {
		
		mapa.agregarEnTierra(this, coordenadas);
		
	}

	@Override
	public void update() {
		recursosDeJugador.agregarRecursos(0, gasRecolectado);
		
	}

}

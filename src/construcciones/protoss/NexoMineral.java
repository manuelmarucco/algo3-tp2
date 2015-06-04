package construcciones.protoss;

import jugabilidad.Mapa;
import jugabilidad.auxiliares.Costo;
import jugabilidad.auxiliares.Recursos;
import jugabilidad.utilidadesMapa.Coordenadas;


public class NexoMineral extends ConstruccionProtoss{

	private final int mineralesRecolectados = 10; //por turno
	private Recursos recursosDeJugador;

	public NexoMineral(Recursos recursos){
		super(250,250);
		nombre = "NexoMineral";
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
		super.update();
	}
	

}

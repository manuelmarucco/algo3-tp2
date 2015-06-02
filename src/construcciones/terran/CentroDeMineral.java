package construcciones.terran;

import jugabilidad.Mapa;
import jugabilidad.utilidadesMapa.Coordenadas;
import fiuba.algo3.algocraft.unidades.Vida;
import auxiliares.Costo;
import auxiliares.Recursos;


public class CentroDeMineral extends ConstruccionTerran {
	
	private Recursos recursosDeJugador;
	private final int mineralesRecolectados = 10;
	
	public CentroDeMineral() {}
	public CentroDeMineral(Recursos recursos){
		nombre = "CentroDeMineral";
		vida = new Vida(500);
		costo = new Costo(50,0);
		tiempoDeConstruccion = 4;
		this.recursosDeJugador = recursos;
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

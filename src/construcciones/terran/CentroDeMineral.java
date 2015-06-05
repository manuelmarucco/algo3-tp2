package construcciones.terran;

import unidades.Vida;
import jugabilidad.Mapa;
import jugabilidad.auxiliares.Costo;
import jugabilidad.utilidadesMapa.Coordenadas;

import jugabilidad.auxiliares.Recursos;
import recursos.Cristal;
import interfaces.Recolectable;

public class CentroDeMineral extends ConstruccionTerran {
	
	private Recursos recursosDeJugador;
	private Recolectable cristal;

	public CentroDeMineral(Recursos recursos){
		nombre = "CentroDeMineral";
		vida = new Vida(500);
		costo = new Costo(50,0);
		tiempoDeConstruccion = 4;
		this.recursosDeJugador = recursos;
	}

	public int obtenerMinerales(){
		return ( this.cristal.recolectarRecursos() );
	}
	
	@Override
	public void agregarse(Mapa mapa, Coordenadas coordenadas) {

		this.cristal = (Recolectable) mapa.getTerrestre(coordenadas);
		mapa.borrarTerrestre(coordenadas);

		mapa.agregarEnTierra(this, coordenadas);
		
	}

	@Override

	public void update() {

		super.update();
		recursosDeJugador.agregarRecursos(this.obtenerMinerales(), 0);

	}

}

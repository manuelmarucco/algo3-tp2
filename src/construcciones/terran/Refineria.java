package construcciones.terran;

import interfaces.Recolectable;
import unidades.Vida;
import jugabilidad.Mapa;
import jugabilidad.auxiliares.Costo;
import jugabilidad.auxiliares.Recursos;
import jugabilidad.utilidadesMapa.Coordenadas;


public class Refineria extends ConstruccionTerran {

	private Recursos recursosDeJugador;
	private Recolectable volcan;
	
	public Refineria(Recursos recursos){
		nombre = "Refineria";
		vida = new Vida(750);
		costo = new Costo(100,0);
		tiempoDeConstruccion = 6;
		recursosDeJugador = recursos;
	}

	public int obtenerMinerales(){
		return ( this.volcan.recolectarRecursos() );
	}

	@Override
	public void agregarse(Mapa mapa, Coordenadas coordenadas) {

		this.volcan = (Recolectable) mapa.getTerrestre(coordenadas);
		mapa.borrarTerrestre(coordenadas);

		mapa.agregarEnTierra(this, coordenadas);
		
	}

	@Override
	public void update() {
		super.update();
		recursosDeJugador.agregarRecursos(0, this.obtenerMinerales());
		
	}

}

package construcciones.terran;

import construcciones.CentroDeRecoleccion;
import interfaces.Recolectable;
import jugabilidad.Mapa;
import jugabilidad.auxiliares.Costo;
import jugabilidad.auxiliares.Recursos;
import jugabilidad.utilidadesMapa.Coordenadas;
import unidades.Vida;


public class Refineria extends CentroDeRecoleccion {

	
	public Refineria(Recursos recursos){
		this.vida = new Vida(750);
		this.costo = new Costo(100,0);
		this.tiempoDeConstruccion = 6;
		this.recursosDeJugador = recursos;
	}


	@Override
	public void agregarse(Mapa mapa, Coordenadas coordenadas) {

		this.estructuraRecolectable = (Recolectable) mapa.getTerrestre(coordenadas);
		mapa.borrarTerrestre(coordenadas);

		mapa.agregarEnTierra(this, coordenadas);
		
	}



	@Override
	public void recibirDanio(int danioParcial){

		vida.quitar(danioParcial);

	}
}

package construcciones.terran;

import interfaces.Construible;

import java.util.ArrayList;

import excepciones.ExcepcionNecesitaConstruirOtroEdificio;
import unidades.Vida;
import jugabilidad.Mapa;
import jugabilidad.auxiliares.Costo;
import jugabilidad.auxiliares.Recursos;
import jugabilidad.utilidadesMapa.Coordenadas;


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
	@Override
	public <T extends Construible> void verificaConstruccionPrevia(
			ArrayList<T> cs) throws ExcepcionNecesitaConstruirOtroEdificio {
		// TODO Auto-generated method stub
		
	}

}

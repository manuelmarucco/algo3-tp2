package construcciones.protoss;

import interfaces.Construible;

import java.util.ArrayList;

import excepciones.ExcepcionNecesitaConstruirOtroEdificio;
import jugabilidad.Mapa;
import jugabilidad.auxiliares.Costo;
import jugabilidad.auxiliares.Recursos;
import jugabilidad.utilidadesMapa.Coordenadas;


public class Asimilador extends ConstruccionProtoss{
	
	private final int gasRecolectado = 10; //por turno
	private Recursos recursosDeJugador;
	
	public Asimilador(Recursos recursos){
		super(450,450);
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
		super.update();
	}


	@Override
	public <T extends Construible> void verificaConstruccionPrevia(
			ArrayList<T> cs) throws ExcepcionNecesitaConstruirOtroEdificio {
		// TODO Auto-generated method stub
		
	}

}

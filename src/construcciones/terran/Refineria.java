package construcciones.terran;

import interfaces.AccionDeEdificio;

import java.util.HashMap;

import construcciones.comandos.AccionesDisponibles;
import construcciones.comandos.terran.accionesDeEdficio.AccionRecolectarMineral;
import auxiliares.Costo;
import auxiliares.Recursos;
import jugabilidad.Mapa;
import jugabilidad.utilidadesMapa.Coordenadas;
import fiuba.algo3.algocraft.unidades.Vida;


public class Refineria extends ConstruccionTerran {

	private Recursos recursosDeJugador;
	private final int gasRecolectados = 10;
	
	public Refineria(){};
	public Refineria(Recursos recursos){
		nombre = "Refineria";
		vida = new Vida(750);
		costo = new Costo(100,0);
		tiempoDeConstruccion = 6;
		recursosDeJugador = recursos;
/*
		acciones = new HashMap<AccionesDisponibles, AccionDeEdificio>();
		acciones.put(AccionesDisponibles.Recolectar,new AccionRecolectarMineral());
		*/
	}


	@Override
	public void agregarse(Mapa mapa, Coordenadas coordenadas) {
		
		mapa.agregarEnTierra(this, coordenadas);
		
	}


	@Override
	public void update() {
		recursosDeJugador.agregarRecursos(0, gasRecolectados);
		
	}

}

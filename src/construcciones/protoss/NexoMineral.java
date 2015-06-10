package construcciones.protoss;

import construcciones.CentroDeRecoleccion;
import excepciones.construicciones.ExcepcionConstruccionNoRecolectaVolcan;
import excepciones.construicciones.ExcepcionNoSePuedeConstruir;
import interfaces.Construible;
import jugabilidad.ProxyMapa;
import jugabilidad.auxiliares.Costo;
import jugabilidad.auxiliares.Recursos;
import jugabilidad.utilidadesMapa.Coordenadas;
import recursos.Recurso;
import unidades.protoss.ResistenciaProtoss;

import java.util.ArrayList;


public class NexoMineral extends CentroDeRecoleccion {

	public NexoMineral(Recursos recursos){

		resistencia = new ResistenciaProtoss(250,250);
		costo = new Costo(50,0);
		tiempoDeConstruccion = 4;
		recursosDeJugador = recursos;
	}

	public int getEscudo() {
		return ((ResistenciaProtoss)resistencia).getEscudoActual();
	}

	@Override
	public <T extends Construible> void esConstruible(ArrayList<T> cs,Recursos recursosRecolectados, Coordenadas coordenadas) throws ExcepcionNoSePuedeConstruir {
		ProxyMapa mapa = ProxyMapa.getInstance();
		Recurso recurso = (Recurso) mapa.obtenerDeCapaDeRecursos(coordenadas);

		if (recurso.noPuedeSerRecolectadoPor(this)){
			throw new ExcepcionConstruccionNoRecolectaVolcan();
		}

		mapa.borrarEnCapaTerrestre(coordenadas);

		super.verificarRecursosDisponibles(recursosRecolectados);

	}

	@Override
	public void update() {
		super.update();
		recursosDeJugador.agregarRecursos(this.obtenerRecurso(), 0);
	}


}

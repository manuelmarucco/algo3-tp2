package construcciones.protoss;

import construcciones.CentroDeRecoleccion;
import excepciones.Mapa.ExcepcionNoSePudoAgregarAlMapa;
import excepciones.construcciones.ExcepcionConstruccionNoRecolectaCristal;
import excepciones.construcciones.ExcepcionLaConstruccionDebeConstruiseSobreUnRecurso;
import excepciones.construcciones.ExcepcionNoSePuedeClonarEdificio;
import excepciones.construcciones.ExcepcionNoSePuedeConstruir;
import interfaces.Clonable;
import interfaces.Construible;
import jugabilidad.Mapa;
import jugabilidad.ProxyMapa;
import jugabilidad.auxiliares.Costo;
import jugabilidad.auxiliares.Recursos;
import jugabilidad.utilidadesMapa.Coordenada;
import recursos.Recurso;
import unidades.protoss.Clon;
import unidades.protoss.ResistenciaProtoss;

import java.util.ArrayList;


public class Asimilador extends CentroDeRecoleccion implements IEdificioProtoss, Clonable{

	public Asimilador(Recursos recursos){

		resistencia = new ResistenciaProtoss(450,450);
		costo = new Costo(100,0);
		tiempoDeConstruccion = 6;
		recursosDeJugador = recursos;
	}


	public int getEscudo() {
		return ((ResistenciaProtoss)resistencia).getEscudoActual();
	}

	@Override
	public <T extends Construible> void esConstruible(ArrayList<T> cs,Recursos recursosRecolectados, Coordenada coordenada) throws ExcepcionNoSePuedeConstruir {
		ProxyMapa mapa = ProxyMapa.getInstance();
		Recurso recurso = (Recurso) mapa.obtenerDeCapaDeRecursos(coordenada);

		if ( recurso == null ){
			throw new ExcepcionLaConstruccionDebeConstruiseSobreUnRecurso();
		}

		if (recurso.noPuedeSerRecolectadoPor(this)){
			throw new ExcepcionConstruccionNoRecolectaCristal();
		}

		mapa.borrarEnCapaTerrestre(coordenada);

		super.verificarRecursosDisponibles(recursosRecolectados);

	}

	@Override
	public void update() {
		super.update();
		recursosDeJugador.agregarRecursos(0, this.obtenerRecurso());
	}

	@Override
	public void moverse(Coordenada hasta, Mapa mapa) throws ExcepcionNoSePudoAgregarAlMapa {

	}

	@Override
	public Clon getClon() throws ExcepcionNoSePuedeClonarEdificio {
		throw new ExcepcionNoSePuedeClonarEdificio();
	}
}

package modelo.construcciones.protoss;

import modelo.construcciones.CentroDeRecoleccion;
import modelo.excepciones.Mapa.ExcepcionNoSePudoAgregarAlMapa;
import modelo.excepciones.construcciones.ExcepcionConstruccionNoRecolectaCristal;
import modelo.excepciones.construcciones.ExcepcionLaConstruccionDebeConstruiseSobreUnRecurso;
import modelo.excepciones.construcciones.ExcepcionNoSePuedeClonarEdificio;
import modelo.excepciones.construcciones.ExcepcionNoSePuedeConstruir;
import modelo.interfaces.Clonable;
import modelo.interfaces.Construible;
import modelo.jugabilidad.Mapa;
import modelo.jugabilidad.ProxyMapa;
import modelo.jugabilidad.auxiliares.Costo;
import modelo.jugabilidad.auxiliares.Recursos;
import modelo.jugabilidad.utilidadesMapa.Coordenada;
import modelo.recursos.Recurso;
import modelo.unidades.protoss.Clon;
import modelo.unidades.protoss.ResistenciaProtoss;

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
		resistencia.regenerar();
	}

	@Override
	public void moverse(Coordenada hasta, Mapa mapa) throws ExcepcionNoSePudoAgregarAlMapa {

	}

	@Override
	public Clon getClon() throws ExcepcionNoSePuedeClonarEdificio {
		throw new ExcepcionNoSePuedeClonarEdificio();
	}
}

package construcciones.terran;

import construcciones.CentroDeRecoleccion;
import excepciones.Mapa.ExcepcionNoSePudoAgregarAlMapa;
import excepciones.construicciones.ExcepcionConstruccionNoRecolectaVolcan;
import excepciones.construicciones.ExcepcionLaConstruccionDebeConstruiseSobreUnRecurso;
import excepciones.construicciones.ExcepcionNoSePuedeConstruir;
import interfaces.Construible;
import jugabilidad.Mapa;
import jugabilidad.ProxyMapa;
import jugabilidad.auxiliares.Costo;
import jugabilidad.auxiliares.Recursos;
import jugabilidad.utilidadesMapa.Coordenada;
import recursos.Recurso;
import unidades.terrran.ResistenciaTerran;

import java.util.ArrayList;

public class CentroDeMineral extends CentroDeRecoleccion {

	public CentroDeMineral(Recursos recursos){
		resistencia = new ResistenciaTerran(500);
		costo = new Costo(50,0);
		tiempoDeConstruccion = 4;
		this.recursosDeJugador = recursos;
	}

	@Override
	public <T extends Construible> void esConstruible(ArrayList<T> cs,Recursos recursosRecolectados, Coordenada coordenada) throws ExcepcionNoSePuedeConstruir {
		ProxyMapa mapa = ProxyMapa.getInstance();
		Recurso recurso = (Recurso) mapa.obtenerDeCapaDeRecursos(coordenada);

		if ( recurso == null ){
			throw new ExcepcionLaConstruccionDebeConstruiseSobreUnRecurso();
		}


		if (recurso.noPuedeSerRecolectadoPor(this)){
			throw new ExcepcionConstruccionNoRecolectaVolcan();
		}

		mapa.borrarEnCapaTerrestre(coordenada);

		super.verificarRecursosDisponibles(recursosRecolectados);

	}

	@Override
	public void update() {
		super.update();
		recursosDeJugador.agregarRecursos(this.obtenerRecurso(), 0);
	}

	@Override
	public void moverse(Coordenada hasta, Mapa mapa) throws ExcepcionNoSePudoAgregarAlMapa {

	}

}

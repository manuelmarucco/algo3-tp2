package modelo.construcciones.terran;

import modelo.construcciones.CentroDeRecoleccion;
import modelo.excepciones.Mapa.ExcepcionNoSePudoAgregarAlMapa;
import modelo.excepciones.construcciones.ExcepcionConstruccionNoRecolectaVolcan;
import modelo.excepciones.construcciones.ExcepcionLaConstruccionDebeConstruiseSobreUnRecurso;
import modelo.excepciones.construcciones.ExcepcionNoSePuedeConstruir;
import modelo.interfaces.Construible;
import modelo.jugabilidad.Mapa;
import modelo.jugabilidad.ProxyMapa;
import modelo.jugabilidad.auxiliares.Costo;
import modelo.jugabilidad.auxiliares.Recursos;
import modelo.jugabilidad.utilidadesMapa.Coordenada;
import modelo.recursos.Recurso;
import modelo.unidades.terrran.ResistenciaTerran;

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

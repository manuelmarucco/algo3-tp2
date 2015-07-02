package modelo.construcciones.terran;

import modelo.construcciones.CentroDeRecoleccion;
import modelo.excepciones.Mapa.ExcepcionNoSePudoAgregarAlMapa;
import modelo.excepciones.construcciones.ExcepcionConstruccionNoRecolectaCristal;
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


public class Refineria extends CentroDeRecoleccion {

	
	public Refineria(Recursos recursos){
		this.resistencia = new ResistenciaTerran(750);
		this.costo = new Costo(100,0);
		this.tiempoDeConstruccion = 6;
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
}

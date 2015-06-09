package construcciones.terran;

import construcciones.CentroDeRecoleccion;
import excepciones.ExcepcionConstruccionNoRecolectaCristal;
import excepciones.ExcepcionLaConstruccionDebeConstruiseSobreUnRecurso;
import excepciones.ExcepcionNoSePuedeConstruir;
import interfaces.Construible;
import jugabilidad.ProxyMapa;
import jugabilidad.auxiliares.Costo;
import jugabilidad.auxiliares.Recursos;
import jugabilidad.utilidadesMapa.Coordenadas;
import recursos.Recurso;
import unidades.terrran.ResistenciaTerran;

import java.util.ArrayList;


public class Refineria extends CentroDeRecoleccion {

	
	public Refineria(Recursos recursos){
		this.resistencia = new ResistenciaTerran(750);
		this.costo = new Costo(100,0);
		this.tiempoDeConstruccion = 6;
		this.recursosDeJugador = recursos;
	}

	@Override
	public <T extends Construible> void esConstruible(ArrayList<T> cs,Recursos recursosRecolectados, Coordenadas coordenadas) throws ExcepcionNoSePuedeConstruir {
		ProxyMapa mapa = ProxyMapa.getInstance();
		Recurso recurso = (Recurso) mapa.obtenerDeCapaDeRecursos(coordenadas);

		if ( recurso == null ){
			throw new ExcepcionLaConstruccionDebeConstruiseSobreUnRecurso();
		}

		if (recurso.noPuedeSerRecolectadoPor(this)){
			throw new ExcepcionConstruccionNoRecolectaCristal();
		}

		mapa.borrarEnCapaTerrestre(coordenadas);

		super.verificarRecursosDisponibles(recursosRecolectados);

	}

	@Override
	public void update() {
		super.update();
		recursosDeJugador.agregarRecursos(0,this.obtenerRecurso());
	}
}

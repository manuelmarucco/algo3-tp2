package construcciones.terran;

import construcciones.CentroDeRecoleccion;
import excepciones.ExcepcionConstruccionNoRecolectaVolcan;
import excepciones.ExcepcionLaConstruccionDebeConstruiseSobreUnRecurso;
import excepciones.ExcepcionNoSePuedeConstruir;
import interfaces.Construible;
import jugabilidad.ProxyMapa;
import jugabilidad.auxiliares.Costo;
import jugabilidad.auxiliares.Recursos;
import jugabilidad.utilidadesMapa.Coordenadas;
import recursos.Recurso;
import unidades.Vida;

import java.util.ArrayList;

public class CentroDeMineral extends CentroDeRecoleccion {

	public CentroDeMineral(Recursos recursos){
		vida = new Vida(500);
		costo = new Costo(50,0);
		tiempoDeConstruccion = 4;
		this.recursosDeJugador = recursos;
	}

	@Override
	public <T extends Construible> void esConstruible(ArrayList<T> cs,Recursos recursosRecolectados, Coordenadas coordenadas) throws ExcepcionNoSePuedeConstruir {
		ProxyMapa mapa = ProxyMapa.getInstance();
		Recurso recurso = (Recurso) mapa.obtenerDeCapaDeRecursos(coordenadas);
		/* TODO: Ver esto.
		if ( recurso == null ){
			throw new ExcepcionLaConstruccionDebeConstruiseSobreUnRecurso();
		}
		*/

		if (recurso.noPuedeSerRecolectadoPor(this)){
			throw new ExcepcionConstruccionNoRecolectaVolcan();
		}

		super.verificarRecursosDisponibles(recursosRecolectados);

	}

	@Override
	public void recibirDanio(int danioParcial){ vida.quitar(danioParcial);}


}

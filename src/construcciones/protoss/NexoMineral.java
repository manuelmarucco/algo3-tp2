package construcciones.protoss;

import construcciones.CentroDeRecoleccion;
import excepciones.ExcepcionConstruccionNoRecolectaVolcan;
import excepciones.ExcepcionNoSePuedeConstruir;
import interfaces.Construible;
import jugabilidad.ProxyMapa;
import jugabilidad.auxiliares.Costo;
import jugabilidad.auxiliares.Recursos;
import jugabilidad.utilidadesMapa.Coordenadas;
import recursos.Recurso;
import unidades.Escudo;
import unidades.Vida;

import java.util.ArrayList;


public class NexoMineral extends CentroDeRecoleccion {

	private Escudo escudo;

	public NexoMineral(Recursos recursos){

		vida = new Vida(250);
		escudo = new Escudo(250);
		costo = new Costo(50,0);
		tiempoDeConstruccion = 4;
		recursosDeJugador = recursos;
	}

	public int getEscudo() {
		return escudo.getEscudoActual();
	}

	@Override
	public void recibirDanio(int danioParcial){
		vida.quitar(escudo.quitar(danioParcial));
	}

	@Override
	public <T extends Construible> void esConstruible(ArrayList<T> cs,Recursos recursosRecolectados, Coordenadas coordenadas) throws ExcepcionNoSePuedeConstruir {
		ProxyMapa mapa = ProxyMapa.getInstance();
		Recurso recurso = (Recurso) mapa.obtenerDeCapaDeRecursos(coordenadas);

		if (recurso.noPuedeSerRecolectadoPor(this)){
			throw new ExcepcionConstruccionNoRecolectaVolcan();
		}

		super.verificarRecursosDisponibles(recursosRecolectados);

	}

}

package construcciones.protoss;

import construcciones.CentroDeRecoleccion;
import excepciones.ExcepcionConstruccionNoRecolectaCristal;
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


public class Asimilador extends CentroDeRecoleccion {

	private Escudo escudo;
	
	public Asimilador(Recursos recursos){

		vida = new Vida(450);
		escudo = new Escudo(450);
		costo = new Costo(100,0);
		tiempoDeConstruccion = 6;
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
			throw new ExcepcionConstruccionNoRecolectaCristal();
		}

		super.verificarRecursosDisponibles(recursosRecolectados);

	}

}

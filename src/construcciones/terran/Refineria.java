package construcciones.terran;

import construcciones.CentroDeRecoleccion;
import excepciones.ExcepcionConstruccionNoRecolectaCristal;
import excepciones.ExcepcionNoSePuedeConstruir;
import interfaces.Construible;
import jugabilidad.ProxyMapa;
import jugabilidad.auxiliares.Costo;
import jugabilidad.auxiliares.Recursos;
import jugabilidad.utilidadesMapa.Coordenadas;
import recursos.Recurso;
import unidades.Vida;

import java.util.ArrayList;


public class Refineria extends CentroDeRecoleccion {

	
	public Refineria(Recursos recursos){
		this.vida = new Vida(750);
		this.costo = new Costo(100,0);
		this.tiempoDeConstruccion = 6;
		this.recursosDeJugador = recursos;
	}

	@Override
	public void recibirDanio(int danioParcial){

		vida.quitar(danioParcial);

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

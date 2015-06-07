package construcciones.terran;

import construcciones.CentroDeRecoleccion;
import excepciones.ExcepcionLaConstruccionNoPuedeRecolectarEsteRecurso;
import interfaces.Recolectable;
import jugabilidad.Mapa;
import jugabilidad.ProxyMapa;
import jugabilidad.auxiliares.Costo;
import jugabilidad.auxiliares.Recursos;
import jugabilidad.utilidadesMapa.Coordenadas;
import recursos.Recurso;
import unidades.Vida;


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

	private Recolectable asignarRecurso(Coordenadas coordenadas)
			throws ExcepcionLaConstruccionNoPuedeRecolectarEsteRecurso {

		ProxyMapa mapa = ProxyMapa.getInstance();
		Recurso recurso = (Recurso) mapa.obtenerDeCapaDeRecursos(coordenadas);

		if (recurso.noPuedeSerRecolectadoPor(this)){

			throw new ExcepcionLaConstruccionNoPuedeRecolectarEsteRecurso();

		}

		return ( recurso );
	}
}

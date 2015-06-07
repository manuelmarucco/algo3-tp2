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

public class CentroDeMineral extends CentroDeRecoleccion {

	public CentroDeMineral(Recursos recursos){
		vida = new Vida(500);
		costo = new Costo(50,0);
		tiempoDeConstruccion = 4;
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

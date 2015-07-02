package modelo.construcciones.terran;


import modelo.construcciones.CentroDeEntrenamiento;
import modelo.excepciones.Mapa.ExcepcionNoSePudoAgregarAlMapa;
import modelo.excepciones.construcciones.ExcepcionNoSePuedeEntrenarUnidad;
import modelo.jugabilidad.Jugador;
import modelo.jugabilidad.Mapa;
import modelo.jugabilidad.auxiliares.Costo;
import modelo.jugabilidad.utilidadesMapa.Coordenada;
import modelo.unidades.terrran.Marine;
import modelo.unidades.terrran.ResistenciaTerran;

public class Barraca extends CentroDeEntrenamiento {


	public Barraca() {
		this.resistencia = new ResistenciaTerran(1000);
		costo = new Costo(150, 0);
		tiempoDeConstruccion = 12;
	} //por ahora para los tests

	public Barraca(Jugador j) {

		this.resistencia = new ResistenciaTerran(1000);
		costo = new Costo(150, 0);
		tiempoDeConstruccion = 12;
		this.jugador = j;

	}


	public Marine entrenarMarine() throws ExcepcionNoSePuedeEntrenarUnidad {
		Marine m = new Marine(this.jugador.getVisibilidad());

		this.validarCreacionUnidad(m);

		this.colaDeEntrenamiento.add(m);

		return m;
	}


	public boolean habilitaAConstruir(Fabrica f) {
		return true;
	}
/*
	public boolean habilitaAConstruir(Construccion c) {
		return c.NecesitaBarraca();
	}
*/
	@Override
	public void moverse(Coordenada hasta, Mapa mapa) throws ExcepcionNoSePudoAgregarAlMapa {

	}
}


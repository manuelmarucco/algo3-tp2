package construcciones.terran;


import construcciones.CentroDeEntrenamiento;
import excepciones.Mapa.ExcepcionNoSePudoAgregarAlMapa;
import excepciones.construicciones.ExcepcionNoSePuedeEntrenarUnidad;
import jugabilidad.Jugador;
import jugabilidad.Mapa;
import jugabilidad.auxiliares.Costo;
import jugabilidad.utilidadesMapa.Coordenadas;
import unidades.terrran.Marine;
import unidades.terrran.ResistenciaTerran;

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
		/*
		try {
			this.validarCreacionUnidad(m);
		} catch (ExcepcionNoSePuedeEntrenarUnidad e) {
			e.printStackTrace();
			return m;
		}
		*/
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
	public void moverse(Coordenadas hasta, Mapa mapa) throws ExcepcionNoSePudoAgregarAlMapa {

	}
}


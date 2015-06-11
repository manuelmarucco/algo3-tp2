package construcciones.terran;


import construcciones.CentroDeEntrenamiento;
import excepciones.construicciones.ExcepcionNoSePuedeEntrenarUnidad;
import jugabilidad.Jugador;
import jugabilidad.auxiliares.Costo;
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


	public Marine entrenarMarine() {
		Marine m = new Marine(this.jugador.getVisibilidad());
		try {
			this.validarCreacionUnidad(m);
		} catch (ExcepcionNoSePuedeEntrenarUnidad e) {
			e.printStackTrace();
			return m;
		}
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
}


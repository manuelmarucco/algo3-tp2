package construcciones.protoss;

import construcciones.CentroDeEntrenamiento;
import excepciones.ExcepcionNoSePuedeEntrenarUnidad;
import jugabilidad.Jugador;
import jugabilidad.auxiliares.Costo;
import unidades.protoss.Dragon;
import unidades.protoss.ResistenciaProtoss;
import unidades.protoss.Zealot;


public class Acceso extends CentroDeEntrenamiento {

	public Acceso(){
		resistencia = new ResistenciaProtoss(500,500);
		costo = new Costo(150,0);
		tiempoDeConstruccion = 8;
	}

	public Acceso(Jugador j){
		resistencia = new ResistenciaProtoss(500,500);
		costo = new Costo(150,0);
		tiempoDeConstruccion = 8;
		this.jugador = j;
	}



	public int getEscudo() {
		return ((ResistenciaProtoss)resistencia).getEscudoActual();
	}

	public boolean habilitaAConstruir(PortalEstelar t) {
		return true;
	}

	public Zealot entrenarZealot(){
		Zealot z = new Zealot();
		try {
			this.validarCreacionUnidad(z);
		} catch (ExcepcionNoSePuedeEntrenarUnidad e) {
			e.printStackTrace();
			return z;
		}
		this.colaDeEntrenamiento.add(z);
		return z;
	}

	public Dragon entrenarDragon(){
		Dragon d = new Dragon();
		try {
			this.validarCreacionUnidad(d);
		} catch (ExcepcionNoSePuedeEntrenarUnidad e) {
			e.printStackTrace();
			return d;
		}
		this.colaDeEntrenamiento.add(d);
		return d;
	}

}

package construcciones.protoss;

import construcciones.CentroDeEntrenamiento;
import excepciones.construicciones.ExcepcionNoSePuedeEntrenarUnidad;
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
	//TODO modificar nombre de variable j
	public Acceso(Jugador j){
		resistencia = new ResistenciaProtoss(500,500);
		costo = new Costo(150,0);
		tiempoDeConstruccion = 8;
		this.jugador = j;
	}



	public int getEscudo() {
		//TODO no deberían castear.
		return ((ResistenciaProtoss)resistencia).getEscudoActual();
	}
	//TODO modificar nombre de variable t
	public boolean habilitaAConstruir(PortalEstelar t) {
		return true;
	}

	public Zealot entrenarZealot(){
		//TODO modificar nombre de variable z
		Zealot z = new Zealot(this.jugador.getVisibilidad());
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
		//TODO modificar nombre de variable d
		Dragon d = new Dragon(this.jugador.getVisibilidad());
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

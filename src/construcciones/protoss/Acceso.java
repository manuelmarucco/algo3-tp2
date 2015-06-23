package construcciones.protoss;

import construcciones.CentroDeEntrenamiento;
import excepciones.Mapa.ExcepcionNoSePudoAgregarAlMapa;
import excepciones.construicciones.ExcepcionNoSePuedeEntrenarUnidad;
import jugabilidad.Jugador;
import jugabilidad.Mapa;
import jugabilidad.auxiliares.Costo;
import jugabilidad.utilidadesMapa.Coordenadas;
import unidades.protoss.Dragon;
import unidades.protoss.ResistenciaProtoss;
import unidades.protoss.Zealot;


public class Acceso extends CentroDeEntrenamiento {

	public Acceso(){
		resistencia = new ResistenciaProtoss(500,500);
		costo = new Costo(150,0);
		tiempoDeConstruccion = 8;
	}

	public Acceso(Jugador jugador){
		resistencia = new ResistenciaProtoss(500,500);
		costo = new Costo(150,0);
		tiempoDeConstruccion = 8;
		this.jugador = jugador;
	}



	public int getEscudo() {
		//TODO no deberían castear.
		return ((ResistenciaProtoss)resistencia).getEscudoActual();
	}

	public boolean habilitaAConstruir(PortalEstelar portalEstelar) {
		return true;
	}

	public Zealot entrenarZealot(){
		Zealot zealot = new Zealot(this.jugador.getVisibilidad());
		try {
			this.validarCreacionUnidad(zealot);
		} catch (ExcepcionNoSePuedeEntrenarUnidad e) {
			e.printStackTrace();
			return zealot;
		}
		this.colaDeEntrenamiento.add(zealot);
		return zealot;
	}

	public Dragon entrenarDragon(){
		Dragon dragon = new Dragon(this.jugador.getVisibilidad());
		try {
			this.validarCreacionUnidad(dragon);
		} catch (ExcepcionNoSePuedeEntrenarUnidad e) {
			e.printStackTrace();
			return dragon;
		}
		this.colaDeEntrenamiento.add(dragon);
		return dragon;
	}

	@Override
	public void moverse(Coordenadas hasta, Mapa mapa) throws ExcepcionNoSePudoAgregarAlMapa {

	}
}

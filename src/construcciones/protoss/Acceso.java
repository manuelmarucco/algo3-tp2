package construcciones.protoss;

import construcciones.CentroDeEntrenamiento;
import excepciones.Mapa.ExcepcionNoSePudoAgregarAlMapa;
import excepciones.construicciones.ExcepcionNoSePuedeEntrenarUnidad;
import jugabilidad.Jugador;
import jugabilidad.Mapa;
import jugabilidad.auxiliares.Costo;
import jugabilidad.utilidadesMapa.Coordenada;
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

	public Zealot entrenarZealot() throws ExcepcionNoSePuedeEntrenarUnidad {
		Zealot zealot = new Zealot(this.jugador.getVisibilidad());

		this.validarCreacionUnidad(zealot);

		this.colaDeEntrenamiento.add(zealot);

		return zealot;
	}

	public Dragon entrenarDragon() throws ExcepcionNoSePuedeEntrenarUnidad {
		Dragon dragon = new Dragon(this.jugador.getVisibilidad());

		this.validarCreacionUnidad(dragon);

		this.colaDeEntrenamiento.add(dragon);

		return dragon;
	}

	@Override
	public void moverse(Coordenada hasta, Mapa mapa) throws ExcepcionNoSePudoAgregarAlMapa {

	}
}

package modelo.construcciones.protoss;

import modelo.construcciones.CentroDeEntrenamiento;
import modelo.excepciones.Mapa.ExcepcionNoSePudoAgregarAlMapa;
import modelo.excepciones.construcciones.ExcepcionNoSePuedeClonarEdificio;
import modelo.excepciones.construcciones.ExcepcionNoSePuedeEntrenarUnidad;
import modelo.interfaces.Clonable;
import modelo.jugabilidad.Jugador;
import modelo.jugabilidad.Mapa;
import modelo.jugabilidad.auxiliares.Costo;
import modelo.jugabilidad.utilidadesMapa.Coordenada;
import modelo.unidades.protoss.Clon;
import modelo.unidades.protoss.Dragon;
import modelo.unidades.protoss.ResistenciaProtoss;
import modelo.unidades.protoss.Zealot;


public class Acceso extends CentroDeEntrenamiento implements IEdificioProtoss, Clonable {

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

	@Override
	public Clon getClon() throws ExcepcionNoSePuedeClonarEdificio {
		throw new ExcepcionNoSePuedeClonarEdificio();
	}

	@Override
	public void update(){
		super.update();
		this.resistencia.regenerar();
	}
}

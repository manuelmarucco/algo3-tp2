package modelo.construcciones.protoss;

import modelo.construcciones.CentroDeEntrenamiento;
import modelo.construcciones.Construccion;
import modelo.excepciones.Mapa.ExcepcionNoSePudoAgregarAlMapa;
import modelo.excepciones.construcciones.ExcepcionNecesitaConstruirAcceso;
import modelo.excepciones.construcciones.ExcepcionNoSePuedeClonarEdificio;
import modelo.excepciones.construcciones.ExcepcionNoSePuedeConstruir;
import modelo.excepciones.construcciones.ExcepcionNoSePuedeEntrenarUnidad;
import modelo.interfaces.Clonable;
import modelo.interfaces.Construible;
import modelo.jugabilidad.Jugador;
import modelo.jugabilidad.Mapa;
import modelo.jugabilidad.auxiliares.Costo;
import modelo.jugabilidad.auxiliares.Recursos;
import modelo.jugabilidad.utilidadesMapa.Coordenada;
import modelo.unidades.protoss.Clon;
import modelo.unidades.protoss.NaveTransporteProtoss;
import modelo.unidades.protoss.ResistenciaProtoss;
import modelo.unidades.protoss.Scout;

import java.util.ArrayList;


public class PortalEstelar extends CentroDeEntrenamiento implements IEdificioProtoss, Clonable {


	public PortalEstelar(){
		resistencia = new ResistenciaProtoss(600,600);
		costo = new Costo(150,150);
		tiempoDeConstruccion = 10;
	}
	public PortalEstelar(Jugador j){
		resistencia = new ResistenciaProtoss(600,600);
		costo = new Costo(150,150);
		tiempoDeConstruccion = 10;
		this.jugador = j;
	}

	public int getEscudo() {
		return ((ResistenciaProtoss)resistencia).getEscudoActual();
	}

	@Override
	public <T extends Construible> void esConstruible(ArrayList<T> cs,Recursos recursosRecolectados,Coordenada coordenada) throws ExcepcionNoSePuedeConstruir {
		boolean construible = false;

		for (T c : cs) {
			if (((Construccion) c).habilitaAConstruir(this))
				construible = true;
		}
		
		if(!construible)
				throw new ExcepcionNecesitaConstruirAcceso();

		super.verificarRecursosDisponibles(recursosRecolectados);
		
	}
	
	public boolean habilitaAConstruir(ArchivosTemplarios t) {
		return true;
	}

	public Scout entrenarScout() throws ExcepcionNoSePuedeEntrenarUnidad {
		Scout scout = new Scout(this.jugador.getVisibilidad());

		this.validarCreacionUnidad(scout);

		this.colaDeEntrenamiento.add(scout);
		return scout;
	}

	public NaveTransporteProtoss entrenarNaveTransporte() throws ExcepcionNoSePuedeEntrenarUnidad {
		NaveTransporteProtoss nave = new NaveTransporteProtoss(this.jugador.getVisibilidad());

		this.validarCreacionUnidad(nave);

		this.colaDeEntrenamiento.add(nave);
		return nave;
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

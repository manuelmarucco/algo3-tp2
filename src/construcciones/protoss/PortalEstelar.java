package construcciones.protoss;

import construcciones.CentroDeEntrenamiento;
import construcciones.Construccion;
import excepciones.Mapa.ExcepcionNoSePudoAgregarAlMapa;
import excepciones.construcciones.ExcepcionNecesitaConstruirAcceso;
import excepciones.construcciones.ExcepcionNoSePuedeClonarEdificio;
import excepciones.construcciones.ExcepcionNoSePuedeConstruir;
import excepciones.construcciones.ExcepcionNoSePuedeEntrenarUnidad;
import interfaces.Clonable;
import interfaces.Construible;
import jugabilidad.Jugador;
import jugabilidad.Mapa;
import jugabilidad.auxiliares.Costo;
import jugabilidad.auxiliares.Recursos;
import jugabilidad.utilidadesMapa.Coordenada;
import unidades.protoss.Clon;
import unidades.protoss.NaveTransporteProtoss;
import unidades.protoss.ResistenciaProtoss;
import unidades.protoss.Scout;

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
	public <T extends Construible> void esConstruible(ArrayList<T> cs,Recursos recursosRecolectados,Coordenada coordenada) throws ExcepcionNoSePuedeConstruir{
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

package modelo.construcciones.protoss;

import modelo.construcciones.CentroDeEntrenamiento;
import modelo.construcciones.Construccion;
import modelo.excepciones.Mapa.ExcepcionNoSePudoAgregarAlMapa;
import modelo.excepciones.construcciones.ExcepcionNecesitaConstruirPortalEstelar;
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
import modelo.unidades.protoss.AltoTemplario;
import modelo.unidades.protoss.Clon;
import modelo.unidades.protoss.ResistenciaProtoss;

import java.util.ArrayList;


public class ArchivosTemplarios extends CentroDeEntrenamiento implements IEdificioProtoss, Clonable {

	public ArchivosTemplarios(){

		resistencia = new ResistenciaProtoss(500,500);
		costo = new Costo(150,200);
		tiempoDeConstruccion = 9;
	}

	public ArchivosTemplarios(Jugador j){

		resistencia = new ResistenciaProtoss(500,500);
		costo = new Costo(150,200);
		tiempoDeConstruccion = 9;
		this. jugador = j;
	}


	public int getEscudo() {
		return ((ResistenciaProtoss)resistencia).getEscudoActual();
	}

	@Override
	public <T extends Construible> void esConstruible(ArrayList<T> cs,Recursos recursosRecolectados, Coordenada coordenada) throws ExcepcionNoSePuedeConstruir {
		boolean construible = false;

		for (T c : cs) {
			if ( ((Construccion)c).habilitaAConstruir(this))
				construible = true;
		}
		
		if(!construible)
				throw new ExcepcionNecesitaConstruirPortalEstelar();

		super.verificarRecursosDisponibles(recursosRecolectados);
		
	}


	public AltoTemplario entrenarAltoTemplario() throws ExcepcionNoSePuedeEntrenarUnidad {
		AltoTemplario altoTemplario = new AltoTemplario(this.jugador.getVisibilidad());

		this.validarCreacionUnidad(altoTemplario);

		this.colaDeEntrenamiento.add(altoTemplario);
		return altoTemplario;
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


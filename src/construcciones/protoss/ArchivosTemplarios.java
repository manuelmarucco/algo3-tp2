package construcciones.protoss;

import construcciones.CentroDeEntrenamiento;
import construcciones.Construccion;
import excepciones.Mapa.ExcepcionNoSePudoAgregarAlMapa;
import excepciones.construicciones.ExcepcionNecesitaConstruirPortalEstelar;
import excepciones.construicciones.ExcepcionNoSePuedeConstruir;
import excepciones.construicciones.ExcepcionNoSePuedeEntrenarUnidad;
import interfaces.Construible;
import jugabilidad.Jugador;
import jugabilidad.Mapa;
import jugabilidad.auxiliares.Costo;
import jugabilidad.auxiliares.Recursos;
import jugabilidad.utilidadesMapa.Coordenadas;
import unidades.protoss.AltoTemplario;
import unidades.protoss.ResistenciaProtoss;

import java.util.ArrayList;


public class ArchivosTemplarios extends CentroDeEntrenamiento {

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
	public <T extends Construible> void esConstruible(ArrayList<T> cs,Recursos recursosRecolectados, Coordenadas coordenadas) throws ExcepcionNoSePuedeConstruir{
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
	public void moverse(Coordenadas hasta, Mapa mapa) throws ExcepcionNoSePudoAgregarAlMapa {

	}
}


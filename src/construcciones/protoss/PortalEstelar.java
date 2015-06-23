package construcciones.protoss;

import construcciones.CentroDeEntrenamiento;
import construcciones.Construccion;
import excepciones.Mapa.ExcepcionNoSePudoAgregarAlMapa;
import excepciones.construicciones.ExcepcionNecesitaConstruirAcceso;
import excepciones.construicciones.ExcepcionNoSePuedeConstruir;
import excepciones.construicciones.ExcepcionNoSePuedeEntrenarUnidad;
import interfaces.Construible;
import jugabilidad.Jugador;
import jugabilidad.Mapa;
import jugabilidad.auxiliares.Costo;
import jugabilidad.auxiliares.Recursos;
import jugabilidad.utilidadesMapa.Coordenadas;
import unidades.protoss.NaveTransporteProtoss;
import unidades.protoss.ResistenciaProtoss;
import unidades.protoss.Scout;

import java.util.ArrayList;


public class PortalEstelar extends CentroDeEntrenamiento{


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
	public <T extends Construible> void esConstruible(ArrayList<T> cs,Recursos recursosRecolectados,Coordenadas coordenadas) throws ExcepcionNoSePuedeConstruir{
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

	public Scout entrenarScout(){
		Scout s = new Scout(this.jugador.getVisibilidad());
		try {
			this.validarCreacionUnidad(s);
		} catch (ExcepcionNoSePuedeEntrenarUnidad e) {
			e.printStackTrace();
			return s;
		}
		this.colaDeEntrenamiento.add(s);
		return s;
	}

	public NaveTransporteProtoss entrenarNaveTransporte(){
		NaveTransporteProtoss n = new NaveTransporteProtoss(this.jugador.getVisibilidad());
		this.colaDeEntrenamiento.add(n);
		return n;
	}

	@Override
	public void moverse(Coordenadas hasta, Mapa mapa) throws ExcepcionNoSePudoAgregarAlMapa {

	}
	
}

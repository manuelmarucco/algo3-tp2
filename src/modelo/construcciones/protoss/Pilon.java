package modelo.construcciones.protoss;

import modelo.construcciones.CentroDeSuministros;
import modelo.excepciones.Mapa.ExcepcionNoSePudoAgregarAlMapa;
import modelo.excepciones.construcciones.ExcepcionNoSePuedeClonarEdificio;
import modelo.interfaces.Clonable;
import modelo.jugabilidad.Mapa;
import modelo.jugabilidad.auxiliares.Costo;
import modelo.jugabilidad.auxiliares.Suministros;
import modelo.jugabilidad.utilidadesMapa.Coordenada;
import modelo.unidades.protoss.Clon;
import modelo.unidades.protoss.ResistenciaProtoss;


public class Pilon extends CentroDeSuministros implements IEdificioProtoss , Clonable {
	
	public Pilon(Suministros suministros){

		resistencia = new ResistenciaProtoss(300,300);
		this.costo = new Costo(100,0);
		this.tiempoDeConstruccion = 5;
		this.capacidadExtra = 5;
		this.suministrosDelJugador = suministros;
		//suministrosDelJugador.aumentarSuministrosLimiteActuales(capacidadExtra);
	}

	public int getEscudo() {
		return ((ResistenciaProtoss)resistencia).getEscudoActual();
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

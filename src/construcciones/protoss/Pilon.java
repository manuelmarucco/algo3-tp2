package construcciones.protoss;

import construcciones.CentroDeSuministros;
import excepciones.Mapa.ExcepcionNoSePudoAgregarAlMapa;
import excepciones.construcciones.ExcepcionNoSePuedeClonarEdificio;
import interfaces.Clonable;
import jugabilidad.Mapa;
import jugabilidad.auxiliares.Costo;
import jugabilidad.auxiliares.Suministros;
import jugabilidad.utilidadesMapa.Coordenada;
import unidades.protoss.Clon;
import unidades.protoss.ResistenciaProtoss;


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

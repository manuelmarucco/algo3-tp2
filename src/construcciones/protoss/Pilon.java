package construcciones.protoss;

import construcciones.CentroDeSuministros;
import jugabilidad.auxiliares.Costo;
import jugabilidad.auxiliares.Suministros;
import unidades.protoss.ResistenciaProtoss;


public class Pilon extends CentroDeSuministros {
	
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

}

package construcciones.comandos.protoss;

import jugabilidad.Jugador;
import construcciones.Construccion;
import construcciones.protoss.NexoMineral;
import interfaces.AccionConstruir;

public class AccionConstruirNexoMineral implements AccionConstruir {

	@Override
	public Construccion accionConstruir(Jugador jugador) {
		NexoMineral nexoMineral = new NexoMineral(jugador.getRecursos());
		return nexoMineral;
	}

}

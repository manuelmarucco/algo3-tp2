package construcciones.protoss.accionesConstruir;

import construcciones.Construccion;
import construcciones.protoss.NexoMineral;
import jugabilidad.Jugador;
import interfaces.AccionConstruir;

public class AccionConstruirNexoMineral implements AccionConstruir {

	@Override
	public Construccion accionConstruir(Jugador jugador) {
		NexoMineral nexoMineral = new NexoMineral(jugador.getRecursos());
		return nexoMineral;
	}

}

package razas.protoss.construcciones.accionesConstruir;

import razas.protoss.construcciones.NexoMineral;
import manejoDeConstrucciones.Construccion;
import jugabilidad.Jugador;
import interfaces.AccionConstruir;

public class AccionConstruirNexoMineral implements AccionConstruir {

	@Override
	public Construccion accionConstruir(Jugador jugador) {
		NexoMineral nexoMineral = new NexoMineral(jugador.getRecursos());
		return nexoMineral;
	}

}

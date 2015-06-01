package construcciones.comandos.protoss.accionesConstruir;

import construcciones.Construccion;
import construcciones.protoss.NexoMineral;
import interfaces.AccionConstruir;

public class AccionConstruirNexoMineral implements AccionConstruir {

	@Override
	public Construccion accionConstruir() {
		NexoMineral nexoMineral = new NexoMineral();
		return nexoMineral;
	}

}

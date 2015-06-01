package construcciones.comandos.protoss.accionesConstruir;

import construcciones.Construccion;
import construcciones.protoss.Asimilador;
import interfaces.AccionConstruir;

public class AccionConstruirAsimilador implements AccionConstruir {

	@Override
	public Construccion accionConstruir() {
		Asimilador asimilador = new Asimilador();
		return asimilador;
	}

}

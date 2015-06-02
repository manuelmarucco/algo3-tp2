package razas.protoss.construcciones.accionesConstruir;

import razas.protoss.construcciones.Asimilador;
import manejoDeConstrucciones.Construccion;
import jugabilidad.Jugador;
import interfaces.AccionConstruir;

public class AccionConstruirAsimilador implements AccionConstruir {

	@Override
	public Construccion accionConstruir(Jugador jugador) {
		Asimilador asimilador = new Asimilador(jugador.getRecursos());
		return asimilador;
	}

}

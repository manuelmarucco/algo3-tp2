package construcciones.protoss.accionesConstruir;

import construcciones.Construccion;
import construcciones.protoss.Asimilador;
import jugabilidad.Jugador;
import interfaces.AccionConstruir;

public class AccionConstruirAsimilador implements AccionConstruir {

	@Override
	public Construccion accionConstruir(Jugador jugador) {
		Asimilador asimilador = new Asimilador(jugador.getRecursos());
		return asimilador;
	}

}

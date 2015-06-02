package construcciones.comandos.protoss;

import jugabilidad.Jugador;
import construcciones.Construccion;
import construcciones.protoss.Asimilador;
import interfaces.AccionConstruir;

public class AccionConstruirAsimilador implements AccionConstruir {

	@Override
	public Construccion accionConstruir(Jugador jugador) {
		Asimilador asimilador = new Asimilador(jugador.getRecursos());
		return asimilador;
	}

}

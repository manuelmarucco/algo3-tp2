package construcciones.comandos.protoss;

import jugabilidad.Jugador;
import construcciones.Construccion;
import construcciones.protoss.Pilon;
import interfaces.AccionConstruir;

public class AccionConstruirPilon implements AccionConstruir {

	@Override
	public Construccion accionConstruir(Jugador jugador) {
		Pilon pilon = new Pilon(jugador.getPoblacionMaxima());
		return pilon;
	}

}

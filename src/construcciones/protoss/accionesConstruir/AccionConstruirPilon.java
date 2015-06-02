package construcciones.protoss.accionesConstruir;

import construcciones.Construccion;
import construcciones.protoss.Pilon;
import jugabilidad.Jugador;
import interfaces.AccionConstruir;

public class AccionConstruirPilon implements AccionConstruir {

	@Override
	public Construccion accionConstruir(Jugador jugador) {
		Pilon pilon = new Pilon(jugador);
		return pilon;
	}

}

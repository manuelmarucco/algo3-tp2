package razas.protoss.construcciones.accionesConstruir;

import razas.protoss.construcciones.Pilon;
import manejoDeConstrucciones.Construccion;
import jugabilidad.Jugador;
import interfaces.AccionConstruir;

public class AccionConstruirPilon implements AccionConstruir {

	@Override
	public Construccion accionConstruir(Jugador jugador) {
		Pilon pilon = new Pilon(jugador);
		return pilon;
	}

}

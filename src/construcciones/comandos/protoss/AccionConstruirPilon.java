package construcciones.comandos.protoss;

import construcciones.Construccion;
import construcciones.protoss.Pilon;
import interfaces.AccionConstruir;

public class AccionConstruirPilon implements AccionConstruir {

	@Override
	public Construccion accionConstruir() {
		Pilon pilon = new Pilon();
		return pilon;
	}

}

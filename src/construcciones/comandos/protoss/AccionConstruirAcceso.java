package construcciones.comandos.protoss;

import construcciones.Construccion;
import construcciones.protoss.Acceso;
import interfaces.AccionConstruir;

public class AccionConstruirAcceso implements AccionConstruir {

	@Override
	public Construccion accionConstruir() {
		Acceso acceso = new Acceso();
		return acceso;
	}

}

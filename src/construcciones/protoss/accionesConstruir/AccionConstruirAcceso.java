package construcciones.protoss.accionesConstruir;

import construcciones.Construccion;
import construcciones.protoss.Acceso;
import jugabilidad.Jugador;
import interfaces.AccionConstruir;

public class AccionConstruirAcceso implements AccionConstruir {

	@Override
	public Construccion accionConstruir(Jugador jugador) {
		Acceso acceso = new Acceso();
		return acceso;
	}

}

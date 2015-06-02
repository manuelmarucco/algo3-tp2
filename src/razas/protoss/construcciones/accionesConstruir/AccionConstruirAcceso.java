package razas.protoss.construcciones.accionesConstruir;

import razas.protoss.construcciones.Acceso;
import manejoDeConstrucciones.Construccion;
import jugabilidad.Jugador;
import interfaces.AccionConstruir;

public class AccionConstruirAcceso implements AccionConstruir {

	@Override
	public Construccion accionConstruir(Jugador jugador) {
		Acceso acceso = new Acceso();
		return acceso;
	}

}

package razas.protoss.construcciones.accionesConstruir;

import razas.protoss.construcciones.PortalEstelar;
import manejoDeConstrucciones.Construccion;
import jugabilidad.Jugador;
import interfaces.AccionConstruir;

public class AccionConstruirPortalEstelar implements AccionConstruir {

	@Override
	public Construccion accionConstruir(Jugador jugador) {
		PortalEstelar portalEstelar = new PortalEstelar();
		return portalEstelar;
	}

}

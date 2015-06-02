package construcciones.protoss.accionesConstruir;

import construcciones.Construccion;
import construcciones.protoss.PortalEstelar;
import jugabilidad.Jugador;
import interfaces.AccionConstruir;

public class AccionConstruirPortalEstelar implements AccionConstruir {

	@Override
	public Construccion accionConstruir(Jugador jugador) {
		PortalEstelar portalEstelar = new PortalEstelar();
		return portalEstelar;
	}

}

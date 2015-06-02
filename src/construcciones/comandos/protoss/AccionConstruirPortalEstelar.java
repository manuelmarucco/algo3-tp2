package construcciones.comandos.protoss;

import jugabilidad.Jugador;
import construcciones.Construccion;
import construcciones.protoss.PortalEstelar;
import interfaces.AccionConstruir;

public class AccionConstruirPortalEstelar implements AccionConstruir {

	@Override
	public Construccion accionConstruir(Jugador jugador) {
		PortalEstelar portalEstelar = new PortalEstelar();
		return portalEstelar;
	}

}

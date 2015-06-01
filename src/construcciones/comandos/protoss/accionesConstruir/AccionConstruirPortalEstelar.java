package construcciones.comandos.protoss.accionesConstruir;

import construcciones.Construccion;
import construcciones.protoss.PortalEstelar;
import interfaces.AccionConstruir;

public class AccionConstruirPortalEstelar implements AccionConstruir {

	@Override
	public Construccion accionConstruir() {
		PortalEstelar portalEstelar = new PortalEstelar();
		return portalEstelar;
	}

}

package construcciones.comandos.protoss;

import jugabilidad.Jugador;
import construcciones.Construccion;
import construcciones.protoss.Acceso;
import interfaces.AccionConstruir;

public class AccionConstruirAcceso implements AccionConstruir {

	@Override
	public Construccion accionConstruir(Jugador jugador) {
		Acceso acceso = new Acceso();
		return acceso;
	}

}

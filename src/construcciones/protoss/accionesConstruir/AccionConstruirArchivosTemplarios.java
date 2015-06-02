package construcciones.protoss.accionesConstruir;

import construcciones.Construccion;
import construcciones.protoss.ArchivosTemplarios;
import jugabilidad.Jugador;
import interfaces.AccionConstruir;

public class AccionConstruirArchivosTemplarios implements AccionConstruir {

	@Override
	public Construccion accionConstruir(Jugador jugador) {
		ArchivosTemplarios archivosTemplarios = new ArchivosTemplarios();
		return archivosTemplarios;
	}

}

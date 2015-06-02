package construcciones.comandos.protoss;

import jugabilidad.Jugador;
import construcciones.Construccion;
import construcciones.protoss.ArchivosTemplarios;
import interfaces.AccionConstruir;

public class AccionConstruirArchivosTemplarios implements AccionConstruir {

	@Override
	public Construccion accionConstruir(Jugador jugador) {
		ArchivosTemplarios archivosTemplarios = new ArchivosTemplarios();
		return archivosTemplarios;
	}

}

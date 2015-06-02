package construcciones.comandos.protoss;

import construcciones.Construccion;
import construcciones.protoss.ArchivosTemplarios;
import interfaces.AccionConstruir;

public class AccionConstruirArchivosTemplarios implements AccionConstruir {

	@Override
	public Construccion accionConstruir() {
		ArchivosTemplarios archivosTemplarios = new ArchivosTemplarios();
		return archivosTemplarios;
	}

}
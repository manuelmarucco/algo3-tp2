package razas.protoss.construcciones.accionesConstruir;

import razas.protoss.construcciones.ArchivosTemplarios;
import manejoDeConstrucciones.Construccion;
import jugabilidad.Jugador;
import interfaces.AccionConstruir;

public class AccionConstruirArchivosTemplarios implements AccionConstruir {

	@Override
	public Construccion accionConstruir(Jugador jugador) {
		ArchivosTemplarios archivosTemplarios = new ArchivosTemplarios();
		return archivosTemplarios;
	}

}

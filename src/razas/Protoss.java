package razas;

import interfaces.AccionConstruir;

import java.util.HashMap;

import razas.protoss.construcciones.accionesConstruir.AccionConstruirAcceso;
import razas.protoss.construcciones.accionesConstruir.AccionConstruirArchivosTemplarios;
import razas.protoss.construcciones.accionesConstruir.AccionConstruirAsimilador;
import razas.protoss.construcciones.accionesConstruir.AccionConstruirNexoMineral;
import razas.protoss.construcciones.accionesConstruir.AccionConstruirPilon;
import razas.protoss.construcciones.accionesConstruir.AccionConstruirPortalEstelar;
import manejoDeConstrucciones.comandos.ConstruccionesDisponibles;

public class Protoss extends Raza {
	
	public Protoss(){
		comandos = new HashMap<ConstruccionesDisponibles,AccionConstruir>();
		
		comandos.put(ConstruccionesDisponibles.ACCESO,new AccionConstruirAcceso());
		comandos.put(ConstruccionesDisponibles.NEXOMINERAL,new AccionConstruirNexoMineral());
		comandos.put(ConstruccionesDisponibles.PILON,new AccionConstruirPilon());
		comandos.put(ConstruccionesDisponibles.ASIMILADOR,new AccionConstruirAsimilador());
		comandos.put(ConstruccionesDisponibles.PORTALESTELAR,new AccionConstruirPortalEstelar());
		comandos.put(ConstruccionesDisponibles.ARCHIVOSTEMPLARIOS,new AccionConstruirArchivosTemplarios());
	}
}

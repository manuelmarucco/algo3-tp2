package razas;

import interfaces.AccionConstruir;

import java.util.HashMap;

import construcciones.comandos.ConstruccionesDisponibles;
import construcciones.protoss.accionesConstruir.AccionConstruirAcceso;
import construcciones.protoss.accionesConstruir.AccionConstruirArchivosTemplarios;
import construcciones.protoss.accionesConstruir.AccionConstruirAsimilador;
import construcciones.protoss.accionesConstruir.AccionConstruirNexoMineral;
import construcciones.protoss.accionesConstruir.AccionConstruirPilon;
import construcciones.protoss.accionesConstruir.AccionConstruirPortalEstelar;

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

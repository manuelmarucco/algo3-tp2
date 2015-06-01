package razas;

import interfaces.AccionConstruir;

import java.util.HashMap;

import construcciones.comandos.ConstruccionesDisponibles;
import construcciones.comandos.protoss.accionesConstruir.AccionConstruirAcceso;
import construcciones.comandos.protoss.accionesConstruir.AccionConstruirArchivosTemplarios;
import construcciones.comandos.protoss.accionesConstruir.AccionConstruirAsimilador;
import construcciones.comandos.protoss.accionesConstruir.AccionConstruirNexoMineral;
import construcciones.comandos.protoss.accionesConstruir.AccionConstruirPilon;
import construcciones.comandos.protoss.accionesConstruir.AccionConstruirPortalEstelar;

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

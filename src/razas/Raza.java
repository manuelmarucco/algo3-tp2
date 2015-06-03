package razas;

import interfaces.AccionConstruir;

import java.util.HashMap;

import construcciones.comandos.ConstruccionesDisponibles;

public class Raza {
	
	protected HashMap<ConstruccionesDisponibles,AccionConstruir> comandos;
	
	public AccionConstruir seleccionarConstruccion(ConstruccionesDisponibles construccion){
		return  comandos.get(construccion);
	}
}

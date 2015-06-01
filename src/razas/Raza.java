package razas;

import interfaces.AccionConstruir;

import java.util.HashMap;

import construcciones.comandos.ConstruccionesDisponibles;

public class Raza {
	
	/*protected Comandos comandos;
	
	public Comandos getComandos(){
		return comandos;
	}*/
	
	protected HashMap<ConstruccionesDisponibles,AccionConstruir> comandos;

	public HashMap<ConstruccionesDisponibles,AccionConstruir> getComandos() {
		return comandos;
	}

	public void setComandos(HashMap<ConstruccionesDisponibles,AccionConstruir> comandos) {
		this.comandos = comandos;
	}
}

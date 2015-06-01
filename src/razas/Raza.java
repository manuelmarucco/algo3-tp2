package razas;

import interfaces.Construible;

import java.util.HashMap;

import construcciones.comandos.ConstruccionesDisponibles;

public class Raza {
	
	protected HashMap<ConstruccionesDisponibles,Construible> comandos;
	
	/*
	public HashMap<ConstruccionesDisponibles,AccionConstruir> getComandos() {
		return comandos;
	}
	*/
	/*
	public void setComandos(HashMap<ConstruccionesDisponibles,AccionConstruir> comandos) {
		this.comandos = comandos;
	}
	*/
	
	public Construible seleccionarConstruccion(ConstruccionesDisponibles construccion){
		return  comandos.get(construccion);
	}
}

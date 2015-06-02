package razas;

import interfaces.AccionConstruir;

import java.util.HashMap;

import manejoDeConstrucciones.comandos.ConstruccionesDisponibles;

public class Raza {
	
	protected HashMap<ConstruccionesDisponibles,AccionConstruir> comandos;
	
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
	
	public AccionConstruir seleccionarConstruccion(ConstruccionesDisponibles construccion){
		return  comandos.get(construccion);
	}
}

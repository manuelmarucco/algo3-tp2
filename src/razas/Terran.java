package razas;

import construcciones.comandos.ConstruccionesDisponibles;
import interfaces.AccionConstruir;

import java.util.HashMap;

public class Terran extends Raza{
	
	/*
	public Terran(){
		comandos = new ComandosTerran();
	}
	*/
	
	public Terran(){
		comandos = new HashMap<ConstruccionesDisponibles,AccionConstruir>();
		/*
		comandos.put(ConstruccionesDisponibles.BARRACA,new AccionConstruirBarraca());
		comandos.put(ConstruccionesDisponibles.FABRICA,new AccionConstruirFabrica());
		*/
	}
	
}

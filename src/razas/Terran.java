package razas;

import construcciones.comandos.AccionConstruirBarraca;
import construcciones.comandos.ComandosTerran;
import construcciones.comandos.ConstruccionesDisponibles;

public class Terran extends Raza{
	
	/*
	public Terran(){
		comandos = new ComandosTerran();
	}
	*/
	
	public Terran(){
		comandos.put(ConstruccionesDisponibles.BARRACA,new AccionConstruirBarraca());
	}
	
}

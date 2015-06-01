package razas;

import interfaces.Construible;

import java.util.HashMap;

import construcciones.comandos.AccionConstruirBarraca;
import construcciones.comandos.AccionConstruirCentroDeMineral;
import construcciones.comandos.AccionConstruirFabrica;
import construcciones.comandos.AccionConstruirPuertoEstelar;
import construcciones.comandos.ConstruccionesDisponibles;

public class Terran extends Raza{
	
	public Terran(){
		comandos = new HashMap<ConstruccionesDisponibles,Construible>();
		
		comandos.put(ConstruccionesDisponibles.BARRACA,new AccionConstruirBarraca());
		comandos.put(ConstruccionesDisponibles.FABRICA,new AccionConstruirFabrica());
		comandos.put(ConstruccionesDisponibles.PUERTOESTELAR,new AccionConstruirPuertoEstelar());
		comandos.put(ConstruccionesDisponibles.CENTRODEMINERAL,new AccionConstruirCentroDeMineral());
	}
	
	
}

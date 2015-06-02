package razas;

import interfaces.AccionConstruir;

import java.util.HashMap;

import construcciones.comandos.ConstruccionesDisponibles;
import construcciones.comandos.terran.AccionConstruirBarraca;
import construcciones.comandos.terran.AccionConstruirCentroDeMineral;
import construcciones.comandos.terran.AccionConstruirDepositoDeSuministros;
import construcciones.comandos.terran.AccionConstruirFabrica;
import construcciones.comandos.terran.AccionConstruirPuertoEstelar;
import construcciones.comandos.terran.AccionConstruirRefineria;

public class Terran extends Raza{
	
	public Terran(){
		comandos = new HashMap<ConstruccionesDisponibles,AccionConstruir>();
		
		comandos.put(ConstruccionesDisponibles.BARRACA,new AccionConstruirBarraca());
		comandos.put(ConstruccionesDisponibles.FABRICA,new AccionConstruirFabrica());
		comandos.put(ConstruccionesDisponibles.PUERTOESTELAR,new AccionConstruirPuertoEstelar());
		comandos.put(ConstruccionesDisponibles.CENTRODEMINERAL,new AccionConstruirCentroDeMineral());
		comandos.put(ConstruccionesDisponibles.REFINERIA,new AccionConstruirRefineria());
		comandos.put(ConstruccionesDisponibles.DEPOSITODESUMINISTROS,new AccionConstruirDepositoDeSuministros());
	}
	
	
}

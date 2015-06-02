package razas;

import interfaces.AccionConstruir;

import java.util.HashMap;

import construcciones.comandos.ConstruccionesDisponibles;
import construcciones.terran.accionesConstruir.AccionConstruirBarraca;
import construcciones.terran.accionesConstruir.AccionConstruirCentroDeMineral;
import construcciones.terran.accionesConstruir.AccionConstruirDepositoDeSuministros;
import construcciones.terran.accionesConstruir.AccionConstruirFabrica;
import construcciones.terran.accionesConstruir.AccionConstruirPuertoEstelar;
import construcciones.terran.accionesConstruir.AccionConstruirRefineria;

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

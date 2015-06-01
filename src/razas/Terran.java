package razas;

import interfaces.AccionConstruir;

import java.util.HashMap;

import construcciones.comandos.ConstruccionesDisponibles;
import construcciones.comandos.terran.accionesConstruir.AccionConstruirBarraca;
import construcciones.comandos.terran.accionesConstruir.AccionConstruirCentroDeMineral;
import construcciones.comandos.terran.accionesConstruir.AccionConstruirFabrica;
import construcciones.comandos.terran.accionesConstruir.AccionConstruirPuertoEstelar;

public class Terran extends Raza{
	
	public Terran(){
		comandos = new HashMap<ConstruccionesDisponibles,AccionConstruir>();
		
		comandos.put(ConstruccionesDisponibles.BARRACA,new AccionConstruirBarraca());
		comandos.put(ConstruccionesDisponibles.FABRICA,new AccionConstruirFabrica());
		comandos.put(ConstruccionesDisponibles.PUERTOESTELAR,new AccionConstruirPuertoEstelar());
		comandos.put(ConstruccionesDisponibles.CENTRODEMINERAL,new AccionConstruirCentroDeMineral());
	}
	
	
}

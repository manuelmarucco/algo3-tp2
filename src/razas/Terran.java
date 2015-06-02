package razas;

import interfaces.AccionConstruir;

import java.util.HashMap;

import razas.terran.construcciones.accionesConstruir.AccionConstruirBarraca;
import razas.terran.construcciones.accionesConstruir.AccionConstruirCentroDeMineral;
import razas.terran.construcciones.accionesConstruir.AccionConstruirDepositoDeSuministros;
import razas.terran.construcciones.accionesConstruir.AccionConstruirFabrica;
import razas.terran.construcciones.accionesConstruir.AccionConstruirPuertoEstelar;
import razas.terran.construcciones.accionesConstruir.AccionConstruirRefineria;
import manejoDeConstrucciones.comandos.ConstruccionesDisponibles;

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

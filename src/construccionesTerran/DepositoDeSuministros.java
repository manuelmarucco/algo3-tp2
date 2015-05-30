package construccionesTerran;

import interfaces.Poblacional;

public class DepositoDeSuministros extends ConstruccionTerran implements Poblacional{
	
	public final int capacidadExtra = 5;
	
	public DepositoDeSuministros(){
		vida = 200;
	}
	
	public void aumentarPoblacionMaxima(){
		//Busca a la instancia de jugador y le aumenta en "capacidadExtra" veces la poblacion maxima.
	}
	
	public int getCapacidadExtra(){
		return capacidadExtra;
	}
}

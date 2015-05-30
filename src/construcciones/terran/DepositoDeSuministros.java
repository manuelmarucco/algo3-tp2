package construcciones.terran;



public class DepositoDeSuministros extends ConstruccionTerran{
	
	private final int capacidadExtra = 5;
	
	public DepositoDeSuministros(){
		vida = 200;
	}
	
	public int getCapacidadExtra(){
		return capacidadExtra;
	}
}

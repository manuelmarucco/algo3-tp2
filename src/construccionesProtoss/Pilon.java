package construccionesProtoss;

public class Pilon extends ConstruccionProtoss{
	
	private final int capacidadExtra = 5;
	
	public Pilon(){
		vida = 200;
		escudo = 50;
	}
	
	public int getCapacidadExtra(){
		return capacidadExtra;
	}
}

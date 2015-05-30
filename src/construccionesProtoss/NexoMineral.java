package construccionesProtoss;

public class NexoMineral extends ConstruccionProtoss{

	private final int mineralRecolectado = 10; //por turno
	
	public NexoMineral(){
		vida = 150;
		escudo = 50;
	}
	
	// esta funcion la debe llamar alguna clase en cada turno y debe modificar el atributo de la instancia Jugador
	//  |
	//  |
	//  v
	public int getMineralRecolectado(){
		return mineralRecolectado;
	}
}

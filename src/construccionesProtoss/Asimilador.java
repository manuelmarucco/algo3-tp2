package construccionesProtoss;

public class Asimilador extends ConstruccionProtoss{
	
	private final int gasRecolectado = 10; //por turno
	
	public Asimilador(){
		vida = 150;
		escudo = 50;
	}
	
	// esta funcion la debe llamar el Jugador u otr clase en cada turno
	//  |
	//  |
	//  v
	public int getGasRecolectado(){
		return gasRecolectado;
	}
	
}

package construccionesTerran;

public class Refineria extends ConstruccionTerran {
	
	public final int gasRecolectado = 10; //por turno
	
	public Refineria(){
		vida = 150;
	}
	
	// esta funcion la debe llamar el Jugador en cada turno
	//  |
	//  |
	//  v
	public int getGasRecolectado(){
		return gasRecolectado;
	}
	
}

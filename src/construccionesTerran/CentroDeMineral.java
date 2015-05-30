package construccionesTerran;

public class CentroDeMineral extends ConstruccionTerran {
	
	private final int mineralRecolectado = 10; //por turno
	
	public CentroDeMineral(){
		vida = 150;
	}
	
	// esta funcion la debe llamar alguna clase en cada turno y debe modificar el atributo de la instancia Jugador
	//  |
	//  |
	//  v
	public int getMineralRecolectado(){
		return mineralRecolectado;
	}
	
}

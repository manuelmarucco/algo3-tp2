package construcciones.protoss;

import jugabilidad.Mapa;
import jugabilidad.utilidadesMapa.Coordenadas;
import fiuba.algo3.algocraft.unidades.parametros.VidaEscudo;


public class Asimilador extends ConstruccionProtoss{
	
	private final int gasRecolectado = 10; //por turno
	
	public Asimilador(){
		vidaEscudo = new VidaEscudo(150,50);
	}
	
	// esta funcion la debe llamar el Jugador u otr clase en cada turno
	//  |
	//  |
	//  v
	public int getGasRecolectado(){
		return gasRecolectado;
	}
	
	@Override
	public void agregarse(Mapa mapa, Coordenadas coordenadas) {
		
		mapa.agregarEnCapaTerrestre(this, coordenadas);
		
	}
}

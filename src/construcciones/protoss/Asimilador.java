package construcciones.protoss;

import auxiliares.Costo;
import jugabilidad.Mapa;
import jugabilidad.utilidadesMapa.Coordenadas;
import fiuba.algo3.algocraft.unidades.VidaEscudo;


public class Asimilador extends ConstruccionProtoss{
	
	private final int gasRecolectado = 10; //por turno
	
	public Asimilador(){
		vidaEscudo = new VidaEscudo(450,450);
		costo = new Costo(100,0);
		tiempoDeConstruccion = 6;
	}
	
	// esta funcion la debe llamar el Jugador u otr clase en cada turno
	//  |
	//  |
	//  v
	public int getGasRecolectado(){
		return gasRecolectado;
	}
	/*
	@Override
	public void agregarse(Mapa mapa, Coordenadas coordenadas) {
		
		mapa.agregarEnTierra(this, coordenadas);
		
	}
	*/
}

package construcciones.terran;

import auxiliares.Costo;
import jugabilidad.Mapa;
import jugabilidad.utilidadesMapa.Coordenadas;
import fiuba.algo3.algocraft.unidades.Vida;


public class Refineria extends ConstruccionTerran {
	
	private final int gasRecolectado = 10; //por turno
	
	public Refineria(){
		nombre = "Refineria";
		vida = new Vida(750);
		costo = new Costo(100,0);
		tiempoDeConstruccion = 6;
	}
	
	// esta funcion la debe llamar el Jugador en cada turno
	//  |
	//  |
	//  v
	public int getGasRecolectado(){
		return gasRecolectado;
	}

	@Override
	public void agregarse(Mapa mapa, Coordenadas coordenadas) {
		
		mapa.agregarEnTierra(this, coordenadas);
		
	}

}

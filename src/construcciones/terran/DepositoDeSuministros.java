package construcciones.terran;

import jugabilidad.Mapa;
import jugabilidad.utilidadesMapa.Coordenadas;
import fiuba.algo3.algocraft.unidades.Vida;
import auxiliares.Costo;



public class DepositoDeSuministros extends ConstruccionTerran {
	
	private final int capacidadExtra = 5;
	
	public DepositoDeSuministros(){
		vida = new Vida(150);
		costo = new Costo(100,0);
	}
	
	public int getCapacidadExtra(){
		return capacidadExtra;
	}
	
	@Override
	public void agregarse(Mapa mapa, Coordenadas coordenadas) {
		
		mapa.agregarEnTierra(this, coordenadas);
		
	}
}

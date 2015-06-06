package construcciones.terran;

import fiuba.algo3.algocraft.unidades.parametros.Vida;
import jugabilidad.Mapa;
import jugabilidad.utilidadesMapa.Coordenadas;



public class DepositoDeSuministros extends ConstruccionTerran {
	
	private final int capacidadExtra = 5;
	
	public DepositoDeSuministros(){
		vida = new Vida(150);
	}
	
	public int getCapacidadExtra(){
		return capacidadExtra;
	}
	
	@Override
	public void agregarse(Mapa mapa, Coordenadas coordenadas) {
		
		mapa.agregarEnCapaTerrestre(this, coordenadas);
		
	}
}

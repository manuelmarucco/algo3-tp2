package construcciones.protoss;

import jugabilidad.Mapa;
import jugabilidad.utilidadesMapa.Coordenadas;
import fiuba.algo3.algocraft.unidades.parametros.VidaEscudo;


public class Pilon extends ConstruccionProtoss{
	
	private final int capacidadExtra = 5;
	
	public Pilon(){
		vidaEscudo = new VidaEscudo(200,50);
	}
	
	public int getCapacidadExtra(){
		return capacidadExtra;
	}
	
	@Override
	public void agregarse(Mapa mapa, Coordenadas coordenadas) {
		
		mapa.agregarEnCapaTerrestre(this, coordenadas);
		
	}
}

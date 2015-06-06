package construcciones.terran;

import fiuba.algo3.algocraft.unidades.parametros.Vida;
import jugabilidad.Mapa;
import jugabilidad.utilidadesMapa.Coordenadas;

public class BaseTerran extends ConstruccionTerran{
	
	public BaseTerran() {
		vida = new Vida(500);
	}

	@Override
	public void agregarse(Mapa mapa, Coordenadas coordenadas) {
		
		mapa.agregarEnCapaTerrestre(this, coordenadas);
		
	}
	
}

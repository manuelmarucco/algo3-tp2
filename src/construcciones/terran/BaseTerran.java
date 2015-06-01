package construcciones.terran;

import auxiliares.Costo;
import fiuba.algo3.algocraft.unidades.parametros.Vida;
import jugabilidad.Mapa;
import jugabilidad.utilidadesMapa.Coordenadas;

public class BaseTerran extends ConstruccionTerran{
	
	public BaseTerran() {
		vida = new Vida(500);
		costo = new Costo(400,0);
	}

	@Override
	public void agregarse(Mapa mapa, Coordenadas coordenadas) {
		
		mapa.agregarEnTierra(this, coordenadas);
		
	}
	
}

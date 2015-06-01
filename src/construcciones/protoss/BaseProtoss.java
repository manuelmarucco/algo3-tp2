package construcciones.protoss;

import jugabilidad.Mapa;
import jugabilidad.utilidadesMapa.Coordenadas;
import fiuba.algo3.algocraft.unidades.parametros.VidaEscudo;

public class BaseProtoss extends ConstruccionProtoss{
	public BaseProtoss() {
		nombre = "BaseProtoss";
		vidaEscudo = new VidaEscudo(400,50);
	}

	@Override
	public void agregarse(Mapa mapa, Coordenadas coordenadas) {
		
		mapa.agregarEnTierra(this, coordenadas);
		
	}
	
}

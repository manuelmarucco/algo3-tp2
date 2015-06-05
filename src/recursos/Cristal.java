package recursos;

import interfaces.ColocableEnMapa;
import interfaces.Recolectable;
import jugabilidad.utilidadesMapa.Coordenadas;
import jugabilidad.Mapa;

public class Cristal implements ColocableEnMapa, Recolectable{

	public void agregarse(Mapa mapa,Coordenadas coordenadas){

		mapa.agregarEnTierra(this , coordenadas);

	}

	@Override
	public int recolectarRecursos() {
		return 10;
	}
}

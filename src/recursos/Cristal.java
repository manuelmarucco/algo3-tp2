package recursos;

import jugabilidad.utilidadesMapa.Coordenadas;
import jugabilidad.Mapa;

public class Cristal extends Recurso{

	public void agregarse(Mapa mapa,Coordenadas coordenadas){

		mapa.agregarEnTierra(this , coordenadas);

	}
	
	@Override
	public int obtenerRecursos() {

		return ( cantidadDeRecursoExplotable);

	}

}

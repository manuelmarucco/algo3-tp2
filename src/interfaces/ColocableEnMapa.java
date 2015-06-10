package interfaces;

import excepciones.Mapa.ExcepcionNoSePudoAgregarAlMapa;
import jugabilidad.utilidadesMapa.Coordenadas;

public interface ColocableEnMapa{

	void agregarse(Coordenadas coordenadas) throws ExcepcionNoSePudoAgregarAlMapa;
	
}

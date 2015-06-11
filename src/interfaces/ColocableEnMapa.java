package interfaces;

import excepciones.Mapa.ExcepcionNoSePudoAgregarAlMapa;
import jugabilidad.Mapa;
import jugabilidad.utilidadesMapa.Coordenadas;

public interface ColocableEnMapa{

	void agregarse(Mapa mapa, Coordenadas coordenadas) throws ExcepcionNoSePudoAgregarAlMapa;
	
}

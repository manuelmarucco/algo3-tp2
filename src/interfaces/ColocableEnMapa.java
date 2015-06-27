package interfaces;

import excepciones.Mapa.ExcepcionNoSePudoAgregarAlMapa;
import jugabilidad.Mapa;
import jugabilidad.utilidadesMapa.Coordenada;

public interface ColocableEnMapa{

	void agregarse(Mapa mapa, Coordenada coordenada) throws ExcepcionNoSePudoAgregarAlMapa;

	void moverse(Coordenada hasta, Mapa mapa) throws  ExcepcionNoSePudoAgregarAlMapa;
	
}

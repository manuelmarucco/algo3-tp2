package modelo.interfaces;

import modelo.excepciones.Mapa.ExcepcionNoSePudoAgregarAlMapa;
import modelo.jugabilidad.Mapa;
import modelo.jugabilidad.utilidadesMapa.Coordenada;

public interface ColocableEnMapa{

	void agregarse(Mapa mapa, Coordenada coordenada) throws ExcepcionNoSePudoAgregarAlMapa;

	void moverse(Coordenada hasta, Mapa mapa) throws  ExcepcionNoSePudoAgregarAlMapa;
	
}

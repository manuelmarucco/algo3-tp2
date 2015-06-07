package interfaces;

import excepciones.ExcepcionPosicionOcupada;
import jugabilidad.Mapa;
import jugabilidad.utilidadesMapa.Coordenadas;

public interface ColocableEnMapa{

	void agregarse(Coordenadas coordenadas) throws ExcepcionPosicionOcupada;
	void agregarse(Mapa mapa,Coordenadas coordenadas) throws ExcepcionPosicionOcupada;
	
}

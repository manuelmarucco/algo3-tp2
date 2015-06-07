package interfaces;

import excepciones.ExcepcionCoordenadaXIngresadaFueraDelMapa;
import excepciones.ExcepcionCoordenadaYIngresadaFueraDelMapa;
import excepciones.ExcepcionNoSePudoAgregarAlMapa;
import excepciones.ExcepcionPosicionOcupada;
import jugabilidad.utilidadesMapa.Coordenadas;

public interface ColocableEnMapa{

	void agregarse(Coordenadas coordenadas) throws ExcepcionPosicionOcupada, ExcepcionCoordenadaXIngresadaFueraDelMapa, ExcepcionCoordenadaYIngresadaFueraDelMapa, ExcepcionNoSePudoAgregarAlMapa;
	
}

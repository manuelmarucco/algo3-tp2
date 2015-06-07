package interfaces;

import excepciones.ExcepcionNoSePudoAgregarAlMapa;
import jugabilidad.utilidadesMapa.Coordenadas;

public interface ColocableEnMapa{

	void agregarse(Coordenadas coordenadas) throws ExcepcionNoSePudoAgregarAlMapa;
	
}

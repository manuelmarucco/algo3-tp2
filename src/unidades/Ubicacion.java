package unidades;

import excepciones.Mapa.ExcepcionNoSePudoAgregarAlMapa;
import excepciones.Mapa.ExcepcionPosicionOcupada;
import interfaces.ColocableEnMapa;
import jugabilidad.Mapa;
import jugabilidad.utilidadesMapa.Coordenadas;

public interface Ubicacion {

    void agregarse(Mapa mapa,ColocableEnMapa unidad,Coordenadas coordenadas) throws ExcepcionPosicionOcupada;

    void moverse(Mapa mapa,ColocableEnMapa unidad,Coordenadas coordenadas) throws ExcepcionNoSePudoAgregarAlMapa;

}

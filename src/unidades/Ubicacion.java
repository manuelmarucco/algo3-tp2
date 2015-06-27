package unidades;

import excepciones.Mapa.ExcepcionNoSePudoAgregarAlMapa;
import excepciones.Mapa.ExcepcionPosicionOcupada;
import interfaces.ColocableEnMapa;
import jugabilidad.Mapa;
import jugabilidad.utilidadesMapa.Coordenada;

public interface Ubicacion {

    void agregarse(Mapa mapa,ColocableEnMapa unidad,Coordenada coordenada) throws ExcepcionPosicionOcupada;

    void moverse(Mapa mapa,ColocableEnMapa unidad,Coordenada coordenada) throws ExcepcionNoSePudoAgregarAlMapa;

}

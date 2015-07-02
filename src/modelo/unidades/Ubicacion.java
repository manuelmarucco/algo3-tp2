package modelo.unidades;

import modelo.excepciones.Mapa.ExcepcionNoSePudoAgregarAlMapa;
import modelo.excepciones.Mapa.ExcepcionPosicionOcupada;
import modelo.interfaces.ColocableEnMapa;
import modelo.jugabilidad.Mapa;
import modelo.jugabilidad.utilidadesMapa.Coordenada;

public interface Ubicacion {

    void agregarse(Mapa mapa,ColocableEnMapa unidad,Coordenada coordenada) throws ExcepcionPosicionOcupada;

    void moverse(Mapa mapa,ColocableEnMapa unidad,Coordenada coordenada) throws ExcepcionNoSePudoAgregarAlMapa;

}

package unidades;

import excepciones.ExcepcionPosicionOcupada;
import interfaces.ColocableEnMapa;
import jugabilidad.Mapa;
import jugabilidad.utilidadesMapa.Coordenadas;

public interface Ubicacion {
    void agregarse(ColocableEnMapa unidad,Mapa mapa, Coordenadas coordenadas) throws ExcepcionPosicionOcupada;
}

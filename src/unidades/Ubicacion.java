package unidades;

import excepciones.Mapa.ExcepcionPosicionOcupada;
import interfaces.ColocableEnMapa;
import jugabilidad.utilidadesMapa.Coordenadas;

public interface Ubicacion {
    void agregarse(ColocableEnMapa unidad,Coordenadas coordenadas) throws ExcepcionPosicionOcupada;
}

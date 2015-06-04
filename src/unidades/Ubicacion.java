package unidades;

import interfaces.ColocableEnMapa;
import jugabilidad.Mapa;
import jugabilidad.utilidadesMapa.Coordenadas;

public interface Ubicacion {
    void agregarse(ColocableEnMapa unidad,Mapa mapa, Coordenadas coordenadas);
}

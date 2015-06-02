package manejoDeUnidades;

import interfaces.ColocableEnMapa;
import jugabilidad.Mapa;
import jugabilidad.utilidadesMapa.Coordenadas;

public interface Ubicacion {
    int danioDe(Danio danio);

    void agregarse(ColocableEnMapa unidad,Mapa mapa, Coordenadas coordenadas);
}

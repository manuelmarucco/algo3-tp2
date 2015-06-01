package fiuba.algo3.algocraft.unidades.terreno;

import fiuba.algo3.algocraft.unidades.parametros.Danio;
import interfaces.ColocableEnMapa;
import jugabilidad.Mapa;
import jugabilidad.utilidadesMapa.Coordenadas;

public interface Ubicacion {
    int danioDe(Danio danio);

    void agregarse(ColocableEnMapa unidad,Mapa mapa, Coordenadas coordenadas);
}

package interfaces;

import jugabilidad.utilidadesMapa.Coordenadas;

public interface Mapa {

    void agregar(ColocableEnMapa colocable, Coordenadas coordenadas);

    ColocableEnMapa getTerrestre(Coordenadas coordenadas);

    boolean posicionTerrestreOcupada( Coordenadas coordenadas );

}

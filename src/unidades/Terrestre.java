package unidades;

import interfaces.ColocableEnMapa;
import jugabilidad.Mapa;
import jugabilidad.utilidadesMapa.Coordenadas;

public class Terrestre implements Ubicacion {

    @Override
    public void agregarse(ColocableEnMapa unidad, Mapa mapa, Coordenadas coordenadas) {
        mapa.agregarEnTierra(unidad,coordenadas);

    }
}

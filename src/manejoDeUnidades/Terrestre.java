package manejoDeUnidades;

import interfaces.ColocableEnMapa;
import jugabilidad.Mapa;
import jugabilidad.utilidadesMapa.Coordenadas;

public class Terrestre implements Ubicacion {
    public int danioDe(Danio danio) {
        return danio.getDanioTierra();
    }

    @Override
    public void agregarse(ColocableEnMapa unidad, Mapa mapa, Coordenadas coordenadas) {
        mapa.agregarEnTierra(unidad,coordenadas);

    }
}

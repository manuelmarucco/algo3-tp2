package unidades;

import excepciones.ExcepcionPosicionOcupada;
import interfaces.ColocableEnMapa;
import jugabilidad.Mapa;
import jugabilidad.utilidadesMapa.Coordenadas;

public class Terrestre implements Ubicacion {

    @Override
    public void agregarse(ColocableEnMapa unidad, Mapa mapa, Coordenadas coordenadas) {
        try {
            mapa.agregarEnCapaTerrestre(unidad, coordenadas);
        } catch (ExcepcionPosicionOcupada e) {
            e.printStackTrace();
        }

    }
}

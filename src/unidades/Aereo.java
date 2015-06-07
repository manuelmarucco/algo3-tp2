package unidades;

import excepciones.ExcepcionPosicionOcupada;
import interfaces.ColocableEnMapa;
import jugabilidad.Mapa;
import jugabilidad.utilidadesMapa.Coordenadas;

public class Aereo implements Ubicacion {

    @Override
    public void agregarse(ColocableEnMapa unidad,Mapa mapa, Coordenadas coordenadas) throws ExcepcionPosicionOcupada {
        mapa.agregarEnCapaAerea(unidad, coordenadas);
    }
}

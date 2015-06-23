package unidades;

import excepciones.Mapa.ExcepcionPosicionOcupada;
import interfaces.ColocableEnMapa;
import jugabilidad.Mapa;
import jugabilidad.ProxyMapa;
import jugabilidad.utilidadesMapa.Coordenadas;

public class Aereo implements Ubicacion {

    @Override
    public void agregarse(Mapa mapa, ColocableEnMapa unidad,Coordenadas coordenadas) throws ExcepcionPosicionOcupada {

        mapa.agregarEnCapaAerea(unidad, coordenadas);

    }

    @Override
    public void moverse(Mapa mapa,ColocableEnMapa unidad,Coordenadas hasta) throws ExcepcionPosicionOcupada {

        mapa.moverEnCapaAerea(unidad, hasta);

    }


}

package unidades;

import excepciones.Mapa.ExcepcionPosicionOcupada;
import interfaces.ColocableEnMapa;
import jugabilidad.Mapa;
import jugabilidad.utilidadesMapa.Coordenada;

public class Aereo implements Ubicacion {

    @Override
    public void agregarse(Mapa mapa, ColocableEnMapa unidad,Coordenada coordenada) throws ExcepcionPosicionOcupada {

        mapa.agregarEnCapaAerea(unidad, coordenada);

    }

    @Override
    public void moverse(Mapa mapa,ColocableEnMapa unidad,Coordenada hasta) throws ExcepcionPosicionOcupada {

        mapa.moverEnCapaAerea(unidad, hasta);

    }


}

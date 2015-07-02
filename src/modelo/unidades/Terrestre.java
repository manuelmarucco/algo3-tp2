package modelo.unidades;

import modelo.excepciones.Mapa.ExcepcionPosicionOcupada;
import modelo.interfaces.ColocableEnMapa;
import modelo.jugabilidad.Mapa;
import modelo.jugabilidad.utilidadesMapa.Coordenada;

public class Terrestre implements Ubicacion {

    @Override
    public void agregarse(Mapa mapa, ColocableEnMapa unidad, Coordenada coordenada) throws ExcepcionPosicionOcupada {
        mapa.agregarEnCapaTerrestre(unidad, coordenada);
    }

    @Override
    public void moverse(Mapa mapa,ColocableEnMapa unidad,Coordenada hasta) throws ExcepcionPosicionOcupada {

        mapa.moverEnCapaTerrestre(unidad, hasta);

    }

}

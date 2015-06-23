package unidades;

import excepciones.Mapa.ExcepcionNoSePudoAgregarAlMapa;
import excepciones.Mapa.ExcepcionPosicionOcupada;
import interfaces.ColocableEnMapa;
import jugabilidad.Mapa;
import jugabilidad.ProxyMapa;
import jugabilidad.utilidadesMapa.Coordenadas;

public class Terrestre implements Ubicacion {

    @Override
    public void agregarse(Mapa mapa, ColocableEnMapa unidad, Coordenadas coordenadas) throws ExcepcionPosicionOcupada {
        mapa.agregarEnCapaTerrestre(unidad,coordenadas);
    }

    @Override
    public void moverse(Mapa mapa,ColocableEnMapa unidad,Coordenadas hasta) throws ExcepcionPosicionOcupada {

        mapa.moverEnCapaTerrestre(unidad, hasta);

    }

}

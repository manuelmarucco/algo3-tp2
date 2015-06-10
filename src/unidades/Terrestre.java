package unidades;

import excepciones.Mapa.ExcepcionPosicionOcupada;
import interfaces.ColocableEnMapa;
import jugabilidad.ProxyMapa;
import jugabilidad.utilidadesMapa.Coordenadas;

public class Terrestre implements Ubicacion {

    @Override
    public void agregarse(ColocableEnMapa unidad,Coordenadas coordenadas) throws ExcepcionPosicionOcupada {
        ProxyMapa mapa = ProxyMapa.getInstance();
        //try {
            mapa.agregarEnCapaTerrestre(unidad, coordenadas);
        //} catch (ExcepcionPosicionOcupada e) {
         //   e.printStackTrace();
       // }

    }
}

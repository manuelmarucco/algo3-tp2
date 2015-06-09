package unidades;

import excepciones.ExcepcionPosicionOcupada;
import interfaces.ColocableEnMapa;
import jugabilidad.ProxyMapa;
import jugabilidad.utilidadesMapa.Coordenadas;

public class Aereo implements Ubicacion {

    @Override
    public void agregarse(ColocableEnMapa unidad,Coordenadas coordenadas) throws ExcepcionPosicionOcupada {
        ProxyMapa mapa = ProxyMapa.getInstance();
        //try {
            mapa.agregarEnCapaAerea(unidad, coordenadas);
        //} catch (ExcepcionPosicionOcupada e) {
         //   e.printStackTrace();
        //}
    }
}

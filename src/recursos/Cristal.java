package recursos;

import excepciones.ExcepcionPosicionOcupada;
import interfaces.ColocableEnMapa;
import interfaces.Recolectable;
import jugabilidad.Mapa;
import jugabilidad.SingletonMapa;
import jugabilidad.utilidadesMapa.Coordenadas;

public class Cristal implements ColocableEnMapa, Recolectable{

    @Override
    public void agregarse(Coordenadas coordenadas) {
        Mapa mapa =SingletonMapa.getInstance();
        try {
            this.agregarse(mapa,coordenadas);
        } catch (ExcepcionPosicionOcupada e) {
            e.printStackTrace();
        }
    }

    public void agregarse(Mapa mapa,Coordenadas coordenadas) throws ExcepcionPosicionOcupada {

        mapa.agregarEnCapaTerrestre(this, coordenadas);

    }

    @Override
    public int recolectarRecursos() {
        return 10;
    }

}

package recursos;

import interfaces.ColocableEnMapa;
import interfaces.Recolectable;
import jugabilidad.SingletonMapa;
import jugabilidad.utilidadesMapa.Coordenadas;
import jugabilidad.Mapa;

public class Cristal implements ColocableEnMapa, Recolectable{

    @Override
    public void agregarse(Coordenadas coordenadas) {
        Mapa mapa =SingletonMapa.getInstance();
        this.agregarse(mapa,coordenadas);
    }

    public void agregarse(Mapa mapa,Coordenadas coordenadas){

        mapa.agregarEnCapaTerrestre(this, coordenadas);

    }

    @Override
    public int recolectarRecursos() {
        return 10;
    }

}

package recursos;

import interfaces.ColocableEnMapa;
import interfaces.Recolectable;
import jugabilidad.Mapa;
import jugabilidad.SingletonMapa;
import jugabilidad.utilidadesMapa.Coordenadas;

public class Volcan implements ColocableEnMapa, Recolectable {

    public void agregarse(Coordenadas coordenadas){
        Mapa mapa = SingletonMapa.getInstance();
        this.agregarse(mapa,coordenadas);

    }

    @Override
    public void agregarse(Mapa mapa, Coordenadas coordenadas) {
        mapa.agregarEnCapaDeRecursos(this, coordenadas);
    }

    @Override
    public int recolectarRecursos() {
        return 10;
    }

}
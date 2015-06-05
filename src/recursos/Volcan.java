package recursos;

import interfaces.ColocableEnMapa;
import interfaces.Recolectable;
import jugabilidad.Mapa;
import jugabilidad.utilidadesMapa.Coordenadas;

public class Volcan implements ColocableEnMapa, Recolectable {

    public void agregarse(Mapa mapa,Coordenadas coordenadas){

        mapa.agregarEnTierra(this , coordenadas);

    }

    @Override
    public int recolectarRecursos() {
        return 10;
    }
}

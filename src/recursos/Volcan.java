package recursos;

import jugabilidad.Mapa;
import jugabilidad.utilidadesMapa.Coordenadas;

public class Volcan extends Recurso {

    public void agregarse(Mapa mapa,Coordenadas coordenadas){

        mapa.agregarEnTierra(this , coordenadas);

    }

    @Override
    public int obtenerRecursos() {

        return ( cantidadDeRecursoExplotable);

    }
}

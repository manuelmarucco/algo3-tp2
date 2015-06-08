package recursos;

import construcciones.CentroDeRecoleccion;
import construcciones.protoss.Asimilador;
import construcciones.protoss.NexoMineral;
import construcciones.terran.Refineria;
import interfaces.ColocableEnMapa;
import interfaces.Recolectable;
import jugabilidad.ProxyMapa;
import jugabilidad.utilidadesMapa.Coordenadas;

public abstract class Recurso implements ColocableEnMapa, Recolectable {

    @Override
    public void agregarse(Coordenadas coordenadas) {

        ProxyMapa mapa = ProxyMapa.getInstance();
        mapa.agregarEnCapaDeRecursos(this,coordenadas);

    }

    public boolean noPuedeSerRecolectadoPor(CentroDeRecoleccion centroDeRecoleccion){
        return false;
    }

    public boolean noPuedeSerRecolectadoPor(Refineria refinera){
        return false;
    }

    public boolean noPuedeSerRecolectadoPor(NexoMineral nexoMineral){
        return false;
    }

    public boolean noPuedeSerRecolectadoPor(Asimilador asimilador){return false;}


}

package recursos;

import construcciones.protoss.Asimilador;
import construcciones.protoss.NexoMineral;
import construcciones.terran.CentroDeMineral;
import construcciones.terran.Refineria;
import excepciones.ExcepcionPosicionOcupada;
import interfaces.ColocableEnMapa;
import interfaces.Recolectable;
import jugabilidad.ProxyMapa;
import jugabilidad.utilidadesMapa.Coordenadas;
import jugabilidad.utilidadesMapa.NullPosicionTerrestre;

public abstract class Recurso implements ColocableEnMapa, Recolectable {

    @Override
    public void agregarse(Coordenadas coordenadas) {

        ProxyMapa mapa = ProxyMapa.getInstance();

        mapa.agregarEnCapaDeRecursos(this,coordenadas);
        // Agrego un NULL OBJECT para que no se pueda construir/caminar sobre los recursos.
        try {
            mapa.agregarEnCapaTerrestre(new NullPosicionTerrestre(), coordenadas);
        } catch (ExcepcionPosicionOcupada e) {
            e.printStackTrace();
        }

    }

    public boolean noPuedeSerRecolectadoPor(CentroDeMineral centroDeMineral){
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

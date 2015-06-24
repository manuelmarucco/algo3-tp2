package recursos;

import construcciones.protoss.Asimilador;
import construcciones.protoss.NexoMineral;
import construcciones.terran.CentroDeMineral;
import construcciones.terran.Refineria;
import excepciones.Mapa.ExcepcionPosicionOcupada;
import interfaces.ColocableEnMapa;
import interfaces.Recolectable;
import jugabilidad.Mapa;
import jugabilidad.utilidadesMapa.Coordenadas;
import jugabilidad.utilidadesMapa.NullPosicionTerrestre;

public abstract class Recurso implements ColocableEnMapa, Recolectable {

    @Override
    public void agregarse(Mapa mapa, Coordenadas coordenadas) {

        try {
            mapa.agregarEnCapaTerrestre( new NullPosicionTerrestre(), coordenadas);
        } catch (ExcepcionPosicionOcupada e) {
            e.printStackTrace();
        }

        mapa.agregarEnCapaDeRecursos(this,coordenadas);

    }

    public boolean noPuedeSerRecolectadoPor(CentroDeMineral centroDeMineral){
        return true;
    }

    public boolean noPuedeSerRecolectadoPor(Refineria refinera){
        return true;
    }

    public boolean noPuedeSerRecolectadoPor(NexoMineral nexoMineral){
        return true;
    }

    public boolean noPuedeSerRecolectadoPor(Asimilador asimilador){return true;}

}

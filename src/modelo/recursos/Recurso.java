package modelo.recursos;

import modelo.construcciones.protoss.Asimilador;
import modelo.construcciones.protoss.NexoMineral;
import modelo.construcciones.terran.CentroDeMineral;
import modelo.construcciones.terran.Refineria;
import modelo.excepciones.Mapa.ExcepcionPosicionOcupada;
import modelo.interfaces.ColocableEnMapa;
import modelo.interfaces.Recolectable;
import modelo.jugabilidad.Mapa;
import modelo.jugabilidad.utilidadesMapa.Coordenada;
import modelo.jugabilidad.utilidadesMapa.NullPosicionTerrestre;

public abstract class Recurso implements ColocableEnMapa, Recolectable {

    @Override
    public void agregarse(Mapa mapa, Coordenada coordenada) {

        try {
            mapa.agregarEnCapaTerrestre( new NullPosicionTerrestre(), coordenada);
        } catch (ExcepcionPosicionOcupada e) {
            e.printStackTrace();
        }

        mapa.agregarEnCapaDeRecursos(this, coordenada);

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

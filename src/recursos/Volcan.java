package recursos;

import construcciones.CentroDeRecoleccion;
import construcciones.protoss.NexoMineral;

public class Volcan extends Recurso {

    @Override
    public int recolectarRecursos() {
        return 10;
    }

    public boolean noPuedeSerRecolectadoPor(CentroDeRecoleccion centroDeRecoleccion){return true;}

    public boolean noPuedeSerRecolectadoPor(NexoMineral nexoMineral){
        return true;
    }
}
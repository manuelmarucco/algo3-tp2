package recursos;

import construcciones.protoss.NexoMineral;
import construcciones.terran.CentroDeMineral;

public class Volcan extends Recurso {

    @Override
    public int recolectarRecursos() {
        return 10;
    }

    public boolean noPuedeSerRecolectadoPor(CentroDeMineral centroDeMineral){return true;}

    public boolean noPuedeSerRecolectadoPor(NexoMineral nexoMineral){
        return true;
    }
}
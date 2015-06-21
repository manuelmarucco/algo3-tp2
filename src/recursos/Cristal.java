package recursos;

import construcciones.protoss.Asimilador;
import construcciones.protoss.NexoMineral;
import construcciones.terran.CentroDeMineral;
import construcciones.terran.Refineria;

public class Cristal extends Recurso{

    public Cristal(){

    }

    @Override
    public int recolectarRecursos() {
        return 10;
    }

    public boolean noPuedeSerRecolectadoPor(NexoMineral nexoMineral){
        return false;
    }

    public boolean noPuedeSerRecolectadoPor(CentroDeMineral centroDeMineral){
        return false;
    }

}

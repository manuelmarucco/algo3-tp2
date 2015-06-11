package recursos;

import construcciones.protoss.Asimilador;
import construcciones.terran.Refineria;

public class Cristal extends Recurso{

    @Override
    public int recolectarRecursos() {
        return 10;
    }


    public boolean noPuedeSerRecolectadoPorr(Refineria refinera){
        return true;
    }
    public boolean noPuedeSerRecolectadoPorr(Asimilador asimilador){
        return true;
    }

}

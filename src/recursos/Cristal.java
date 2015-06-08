package recursos;

import construcciones.protoss.Asimilador;
import construcciones.terran.Refineria;

public class Cristal extends Recurso{

    @Override
    public int recolectarRecursos() {
        return 10;
    }

    public boolean noPuedeSerRecolectadoPor(Refineria refinera){
        return true;
    }
    public boolean noPuedeSerRecolectadoPor(Asimilador asimilador){
        return true;
    }

}

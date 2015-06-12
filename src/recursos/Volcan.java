package recursos;

import construcciones.protoss.Asimilador;
import construcciones.terran.Refineria;

public class Volcan extends Recurso {

    @Override
    public int recolectarRecursos() {
        return 10;
    }

    public boolean noPuedeSerRecolectadoPor(Refineria refinera){
        return false;
    }

    public boolean noPuedeSerRecolectadoPor(Asimilador asimilador){
        return false;
    }
}
package recursos;

import construcciones.CentroDeRecoleccion;
import construcciones.terran.Refineria;

public class Cristal extends Recurso{

    @Override
    public int recolectarRecursos() {
        return 10;
    }

    public boolean noPuedeSerRecolectadoPor(CentroDeRecoleccion centroDeRecoleccion){
        return false;
    }

    public boolean noPuedeSerRecolectadoPor(Refineria refinera){
        return true;
    }

}

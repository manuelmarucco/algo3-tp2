package recursos;

import construcciones.CentroDeRecoleccion;
import construcciones.terran.Refineria;

public class Volcan extends Recurso {

    @Override
    public int recolectarRecursos() {
        return 10;
    }

    public boolean puedeSerRecolectadoPor(CentroDeRecoleccion centroDeRecoleccion){
        return true;
    }

    public boolean puedeSerRecolectadoPor(Refineria refinera){
        return false;
    }

}
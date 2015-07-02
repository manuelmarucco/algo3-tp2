package modelo.recursos;

import modelo.construcciones.protoss.NexoMineral;
import modelo.construcciones.terran.CentroDeMineral;
import modelo.excepciones.Mapa.ExcepcionNoSePudoAgregarAlMapa;
import modelo.jugabilidad.Mapa;
import modelo.jugabilidad.utilidadesMapa.Coordenada;

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

    @Override
    public void moverse(Coordenada hasta, Mapa mapa) throws ExcepcionNoSePudoAgregarAlMapa {

    }

}

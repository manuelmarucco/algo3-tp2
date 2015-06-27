package recursos;

import construcciones.protoss.NexoMineral;
import construcciones.terran.CentroDeMineral;
import excepciones.Mapa.ExcepcionNoSePudoAgregarAlMapa;
import jugabilidad.Mapa;
import jugabilidad.utilidadesMapa.Coordenada;

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

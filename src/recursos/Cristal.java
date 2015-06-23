package recursos;

import construcciones.protoss.Asimilador;
import construcciones.protoss.NexoMineral;
import construcciones.terran.CentroDeMineral;
import construcciones.terran.Refineria;
import excepciones.Mapa.ExcepcionNoSePudoAgregarAlMapa;
import jugabilidad.Mapa;
import jugabilidad.utilidadesMapa.Coordenadas;

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
    public void moverse(Coordenadas hasta, Mapa mapa) throws ExcepcionNoSePudoAgregarAlMapa {

    }

}

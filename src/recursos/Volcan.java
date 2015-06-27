package recursos;

import construcciones.protoss.Asimilador;
import construcciones.terran.Refineria;
import excepciones.Mapa.ExcepcionNoSePudoAgregarAlMapa;
import jugabilidad.Mapa;
import jugabilidad.utilidadesMapa.Coordenada;

public class Volcan extends Recurso {

    public Volcan(){

    }

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

    @Override
    public void moverse(Coordenada hasta, Mapa mapa) throws ExcepcionNoSePudoAgregarAlMapa {

    }

}
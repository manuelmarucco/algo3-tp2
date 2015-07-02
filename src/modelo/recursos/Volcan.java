package modelo.recursos;

import modelo.construcciones.protoss.Asimilador;
import modelo.construcciones.terran.Refineria;
import modelo.excepciones.Mapa.ExcepcionNoSePudoAgregarAlMapa;
import modelo.jugabilidad.Mapa;
import modelo.jugabilidad.utilidadesMapa.Coordenada;

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
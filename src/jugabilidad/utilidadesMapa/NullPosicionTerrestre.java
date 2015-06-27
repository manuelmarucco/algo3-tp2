package jugabilidad.utilidadesMapa;

import excepciones.Mapa.ExcepcionNoSePudoAgregarAlMapa;
import interfaces.ColocableEnMapa;
import jugabilidad.Mapa;

public class NullPosicionTerrestre implements ColocableEnMapa {

    public NullPosicionTerrestre(){

    }

    @Override
    public void agregarse(Mapa mapa, Coordenada coordenada) throws ExcepcionNoSePudoAgregarAlMapa {

        mapa.agregarEnCapaTerrestre(this, coordenada);

    }

    @Override
    public void moverse(Coordenada hasta, Mapa mapa) throws ExcepcionNoSePudoAgregarAlMapa{

    }
}

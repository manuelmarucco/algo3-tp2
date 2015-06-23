package jugabilidad.utilidadesMapa;

import excepciones.Mapa.ExcepcionNoSePudoAgregarAlMapa;
import interfaces.ColocableEnMapa;
import jugabilidad.Mapa;

public class NullPosicionTerrestre implements ColocableEnMapa {

    public NullPosicionTerrestre(){

    }

    @Override
    public void agregarse(Mapa mapa, Coordenadas coordenadas) throws ExcepcionNoSePudoAgregarAlMapa {

        mapa.agregarEnCapaTerrestre(this, coordenadas);

    }

    @Override
    public void moverse(Coordenadas hasta, Mapa mapa) throws ExcepcionNoSePudoAgregarAlMapa{

    }
}

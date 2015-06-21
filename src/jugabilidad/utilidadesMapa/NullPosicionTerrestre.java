package jugabilidad.utilidadesMapa;

import excepciones.Mapa.ExcepcionNoSePudoAgregarAlMapa;
import interfaces.ColocableEnMapa;
import jugabilidad.Mapa;
import jugabilidad.ProxyMapa;
import org.apache.commons.lang3.ObjectUtils;

public class NullPosicionTerrestre implements ColocableEnMapa {

    public NullPosicionTerrestre(){

    }

    @Override
    public void agregarse(Mapa mapa, Coordenadas coordenadas) throws ExcepcionNoSePudoAgregarAlMapa {

        mapa.agregarEnCapaTerrestre(this, coordenadas);

    }
}

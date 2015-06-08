package jugabilidad.utilidadesMapa;

import excepciones.ExcepcionNoSePudoAgregarAlMapa;
import interfaces.ColocableEnMapa;
import jugabilidad.ProxyMapa;

public class NullPosicionTerrestre implements ColocableEnMapa {


    @Override
    public void agregarse(Coordenadas coordenadas) throws ExcepcionNoSePudoAgregarAlMapa {
        ProxyMapa proxyMapa = ProxyMapa.getInstance();

        proxyMapa.agregarEnCapaTerrestre(this, coordenadas);
    }
}

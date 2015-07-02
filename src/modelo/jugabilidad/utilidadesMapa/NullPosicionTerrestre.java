package modelo.jugabilidad.utilidadesMapa;

import modelo.excepciones.Mapa.ExcepcionNoSePudoAgregarAlMapa;
import modelo.interfaces.ColocableEnMapa;
import modelo.interfaces.Hechizable;
import modelo.jugabilidad.Mapa;

public class NullPosicionTerrestre implements ColocableEnMapa, Hechizable {

    public NullPosicionTerrestre(){

    }

    @Override
    public void agregarse(Mapa mapa, Coordenada coordenada) throws ExcepcionNoSePudoAgregarAlMapa {

        mapa.agregarEnCapaTerrestre(this, coordenada);

    }

    @Override
    public void moverse(Coordenada hasta, Mapa mapa) throws ExcepcionNoSePudoAgregarAlMapa{

    }

    @Override
    public void recibirEMP() {

    }

    @Override
    public void irradiar() {

    }

    @Override
    public void recibirDanio(int danio) {

    }

    @Override
    public void recibirRadiacion(int danioAire) {

    }
}

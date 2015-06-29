package construcciones;

import excepciones.Mapa.ExcepcionNoSePudoAgregarAlMapa;
import excepciones.Mapa.ExcepcionPosicionOcupada;
import interfaces.ColocableEnMapa;
import interfaces.Recolectable;
import jugabilidad.Mapa;
import jugabilidad.ProxyMapa;
import jugabilidad.auxiliares.Recursos;
import jugabilidad.utilidadesMapa.Coordenada;

public abstract class CentroDeRecoleccion extends Construccion {

    protected Recursos recursosDeJugador;
    protected Recolectable estructuraRecolectable;

    @Override
    public void agregarse(Mapa mapa, Coordenada coordenada) {

        this.estructuraRecolectable = (Recolectable) mapa.obtenerDeCapaDeRecursos(coordenada);

        // Borra el NULL OBJECT
        mapa.borrarEnCapaTerrestre(coordenada);
        // Saco el recurso del mapa. Cuando el edificio sea destruido lo repongo.
        mapa.borrarEnCapaDeRecursos(coordenada);

        try {
            mapa.agregarEnCapaTerrestre(this, coordenada);
        } catch (ExcepcionPosicionOcupada e) {
            e.printStackTrace();
        }

    }

    @Override
    public void update() {
        ProxyMapa mapa = ProxyMapa.getInstance();

        if(resistencia.getVidaActual() == 0){
            try {
                mapa.agregar((ColocableEnMapa) this.estructuraRecolectable, mapa.getCoordenada(this));
            } catch (ExcepcionNoSePudoAgregarAlMapa e) {
                e.printStackTrace();
            }
            mapa.borrarEnCapaTerrestre(mapa.getCoordenada(this));
        }

    }

    public int obtenerRecurso(){

        return ( this.estructuraRecolectable.recolectarRecursos() );

    }

}

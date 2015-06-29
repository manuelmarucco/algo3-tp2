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
    protected void verificarDestruccionDeEdificio(){

        ProxyMapa mapa = ProxyMapa.getInstance();

        if(resistencia.getVidaActual() == 0){
            Coordenada coordenadasDelEdificio = mapa.getCoordenada(this);

            mapa.borrarEnCapaTerrestre(mapa.getCoordenada(this));
            try {
                mapa.agregar((ColocableEnMapa) this.estructuraRecolectable, coordenadasDelEdificio);
            } catch (ExcepcionNoSePudoAgregarAlMapa e) {
                e.printStackTrace();
            }
        }

    }

    public int obtenerRecurso(){

        return ( this.estructuraRecolectable.recolectarRecursos() );

    }

}

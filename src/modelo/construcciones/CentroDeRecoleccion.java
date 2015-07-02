package modelo.construcciones;

import modelo.excepciones.Mapa.ExcepcionPosicionOcupada;
import modelo.interfaces.Recolectable;
import modelo.jugabilidad.Mapa;
import modelo.jugabilidad.ProxyMapa;
import modelo.jugabilidad.auxiliares.Recursos;
import modelo.jugabilidad.utilidadesMapa.Coordenada;

public abstract class CentroDeRecoleccion extends Construccion {

    protected Recursos recursosDeJugador;
    protected Recolectable estructuraRecolectable;

    @Override
    public void agregarse(Mapa mapa, Coordenada coordenada) {

        if ( mapa.posicionDeRecursosOcupada(coordenada) ) {

            this.estructuraRecolectable = (Recolectable) mapa.obtenerDeCapaDeRecursos(coordenada);

            // Borra el NULL OBJECT
            mapa.borrarEnCapaTerrestre(coordenada);

            try {
                mapa.agregarEnCapaTerrestre(this, coordenada);
            } catch (ExcepcionPosicionOcupada e) {
                e.printStackTrace();
            }

        }

    }

    @Override
    protected void verificarDestruccionDeEdificio(){

        ProxyMapa mapa = ProxyMapa.getInstance();

        if(resistencia.getVidaActual() == 0){
            mapa.borrarEnCapaTerrestre(mapa.getCoordenada(this));
        }

    }

    public int obtenerRecurso(){

        return ( this.estructuraRecolectable.recolectarRecursos() );

    }

}

package construcciones;

import excepciones.Mapa.ExcepcionPosicionOcupada;
import interfaces.Recolectable;
import jugabilidad.ProxyMapa;
import jugabilidad.auxiliares.Recursos;
import jugabilidad.utilidadesMapa.Coordenadas;

public abstract class CentroDeRecoleccion extends Construccion {

    protected Recursos recursosDeJugador;
    protected Recolectable estructuraRecolectable;

    @Override
    public void agregarse(Coordenadas coordenadas) {

        ProxyMapa mapa= ProxyMapa.getInstance();

        this.estructuraRecolectable = (Recolectable) mapa.obtenerDeCapaDeRecursos(coordenadas);

        // Borra el NULL OBJECT
        mapa.borrarEnCapaTerrestre(coordenadas);

        try {
            mapa.agregarEnCapaTerrestre(this, coordenadas);
        } catch (ExcepcionPosicionOcupada e) {
            e.printStackTrace();
        }

    }

    public int obtenerRecurso(){

        return ( this.estructuraRecolectable.recolectarRecursos() );

    }
}

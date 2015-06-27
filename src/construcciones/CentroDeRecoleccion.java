package construcciones;

import excepciones.Mapa.ExcepcionPosicionOcupada;
import interfaces.Recolectable;
import jugabilidad.Mapa;
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

        try {
            mapa.agregarEnCapaTerrestre(this, coordenada);
        } catch (ExcepcionPosicionOcupada e) {
            e.printStackTrace();
        }

    }

    public int obtenerRecurso(){

        return ( this.estructuraRecolectable.recolectarRecursos() );

    }

}

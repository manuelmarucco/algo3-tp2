package construcciones;

import excepciones.ExcepcionPosicionOcupada;
import interfaces.Recolectable;
import jugabilidad.Mapa;
import jugabilidad.SingletonMapa;
import jugabilidad.auxiliares.Recursos;
import jugabilidad.utilidadesMapa.Coordenadas;

public abstract class CentroDeRecoleccion extends Construccion {

    protected Recursos recursosDeJugador;
    protected Recolectable estructuraRecolectable;

    @Override
    public void recibirDanio(int danioParcial) {

    }

    @Override
    public void update() {
       // super.update();
        recursosDeJugador.agregarRecursos(0, this.obtenerRecurso());

    }


    @Override
    public void agregarse(Coordenadas coordenadas) {
        Mapa mapa= SingletonMapa.getInstance();
        
        this.estructuraRecolectable = (Recolectable) mapa.obtenerDeCapaRecursos(coordenadas);
        mapa.borrarTerrestre(coordenadas);

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

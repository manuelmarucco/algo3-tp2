package construcciones;

import excepciones.ExcepcionLaConstruccionNoPuedeRecolectarEsteRecurso;
import excepciones.ExcepcionPosicionOcupada;
import interfaces.Recolectable;
import jugabilidad.ProxyMapa;
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

        ProxyMapa mapa= ProxyMapa.getInstance();

        try {
            this.estructuraRecolectable = this.asignarRecurso(coordenadas);
        }catch(ExcepcionLaConstruccionNoPuedeRecolectarEsteRecurso e){
            e.printStackTrace();
        }

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

    private Recolectable asignarRecurso(Coordenadas coordenadas)
            throws ExcepcionLaConstruccionNoPuedeRecolectarEsteRecurso {

        ProxyMapa mapa= ProxyMapa.getInstance();

        return ( (Recolectable) mapa.obtenerDeCapaDeRecursos(coordenadas) );
    }

}

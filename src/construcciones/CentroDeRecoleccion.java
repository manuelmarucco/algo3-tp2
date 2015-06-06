package construcciones;

import interfaces.Recolectable;
import jugabilidad.Mapa;
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
    public void agregarse(Mapa mapa, Coordenadas coordenadas) {

        this.estructuraRecolectable = (Recolectable) mapa.getTerrestre(coordenadas);
        mapa.borrarTerrestre(coordenadas);

        mapa.agregarEnTierra(this, coordenadas);

    }

    public int obtenerRecurso(){
        return ( this.estructuraRecolectable.recolectarRecursos() );
    }

}

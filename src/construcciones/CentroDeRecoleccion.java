package construcciones;

import interfaces.Recolectable;
import jugabilidad.auxiliares.Recursos;

public abstract class CentroDeRecoleccion extends Construccion {

    protected Recursos recursosDeJugador;
    protected Recolectable estructuraRecolectable;

    @Override
    public void recibirDanio(int danioParcial) {

    }

    @Override
    public void update() {
        super.update();
        recursosDeJugador.agregarRecursos(0, this.obtenerRecurso());

    }

    public int obtenerRecurso(){
        return ( this.estructuraRecolectable.recolectarRecursos() );
    }

}

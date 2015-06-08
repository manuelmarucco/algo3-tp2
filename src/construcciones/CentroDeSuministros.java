package construcciones;

import jugabilidad.auxiliares.Suministros;

public abstract class CentroDeSuministros extends Construccion {

    protected int capacidadExtra;
    protected Suministros suministrosDelJugador;
    protected boolean capacidadAumentada;

    @Override
    public void update() {
        if(!capacidadAumentada){
            suministrosDelJugador.aumentarSuministrosLimiteActuales(capacidadExtra);
            capacidadAumentada = true;
        }
        if(resistencia.getVidaActual() == 0){
            suministrosDelJugador.disminuirSuministrosLimiteActuales(capacidadExtra);
        }
    }

    public int getCapacidadExtra(){
        return capacidadExtra;
    }

}

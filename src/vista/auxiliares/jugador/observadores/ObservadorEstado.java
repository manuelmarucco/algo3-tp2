package vista.auxiliares.jugador.observadores;


import vista.auxiliares.jugador.displays.DisplayEstado;

import java.util.ArrayList;

public class ObservadorEstado {

    private static ObservadorEstado singleton;
    private ArrayList<DisplayEstado> displaysEstado = new ArrayList<>();

    public static ObservadorEstado getInstance(){

        if(singleton == null){

            singleton = new ObservadorEstado();

        }
        return singleton;
    }

    private ObservadorEstado(){

    }

    public void informarCambios(){

        this.actualizarDisplaysEstado();

    }
    public void agregarDisplayEstadoDelJugador( DisplayEstado displayEstado){

        this.displaysEstado.add( displayEstado );

    }

    private void actualizarDisplaysEstado(){

        if (displaysEstado != null){

            for (  DisplayEstado displayEstado : this.displaysEstado ){

                displayEstado.repaint();

            }

        }

    }

}
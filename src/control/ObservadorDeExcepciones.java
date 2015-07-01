package control;

import vista.auxiliares.jugador.displays.DisplayNotificaciones;
import vista.sonido.SonidosDelJuego;

import java.util.ArrayList;

public class ObservadorDeExcepciones {

    private static ObservadorDeExcepciones singleton;
    private ArrayList<DisplayNotificaciones> displays = new ArrayList<>();

    public static ObservadorDeExcepciones getInstance(){

        if(singleton == null){

            singleton = new ObservadorDeExcepciones();

        }
        return singleton;
    }

    private ObservadorDeExcepciones(){

    }

    public void informarNuevaExcepcion(Exception e){

        String alerta = e.getMessage();

        SonidosDelJuego.getInstance().reproducirError();

        this.enviarAlertasAlPanel(alerta);

    }

    public void informarNuevaExcepcion(Throwable e){

        String alerta = e.getMessage();
        this.enviarAlertasAlPanel(alerta);

    }


    private void enviarAlertasAlPanel(String informacionDeAlerta){

        if ( this.displays != null ){

            for ( DisplayNotificaciones display : this.displays ){

                display.mostrarNotificacion(informacionDeAlerta);

            }

        }

    }

    public void agregarDisplay(DisplayNotificaciones display){

        displays.add( display );

    }

    public void borrarDisplay(){

        if ( this.displays != null ){

            for ( DisplayNotificaciones display : this.displays ){

                display.borrarNotificaciones();

            }

        }

    }

}

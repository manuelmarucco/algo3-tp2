package control;

import vista.auxiliares.jugador.DisplayNotificaciones;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class NotificadorDeAlertas {

    private static NotificadorDeAlertas proxy;
    private ArrayList<DisplayNotificaciones> displays = new ArrayList<>();

    public static NotificadorDeAlertas getInstance(){

        if(proxy == null){

            proxy = new NotificadorDeAlertas();

        }
        return proxy;
    }

    private NotificadorDeAlertas(){

    }

    public void informarNuevaExcepcion(Exception e){

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

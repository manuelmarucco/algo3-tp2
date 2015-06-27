package vista.ventanaJugadores;


import java.util.ArrayList;

public class ObservadorEstado {

    private static ObservadorEstado singleton;
    private ArrayList<VentanaJugador> ventanas = new ArrayList<>();

    public static ObservadorEstado getInstance(){

        if(singleton == null){

            singleton = new ObservadorEstado();

        }
        return singleton;
    }

    private ObservadorEstado(){

    }

    public void informarCambios(){

        this.actualizarVentanas();

    }

    public void agregarVentana( VentanaJugador ventana){

        this.ventanas.add( ventana );

    }

    private void actualizarVentanas(){

        if (ventanas != null){

            for (  VentanaJugador ventana : this.ventanas ){

                ventana.actualizarPanelDeEstado();

            }

        }

    }

}
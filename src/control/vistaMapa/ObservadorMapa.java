package control.vistaMapa;

import vista.auxiliares.jugador.displays.DisplayMapa;

import java.util.ArrayList;

public class ObservadorMapa {

    private static ObservadorMapa singleton;
    private ArrayList<DisplayMapa> diplays = new ArrayList<>();

    public static ObservadorMapa getInstance(){

        if(singleton == null){

            singleton = new ObservadorMapa();

        }
        return singleton;
    }

    private ObservadorMapa(){

    }

    public void informarCambios(){

        this.actualizarDisplays();

    }

    public void agregarDisplay( DisplayMapa display ){

        this.diplays.add( display );

    }

    private void actualizarDisplays(){

        if (diplays != null){

            for ( DisplayMapa display : this.diplays ){

                display.actualizarDisplayMapa();

            }

        }

    }

}

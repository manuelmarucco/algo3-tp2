package control.vistaMapa;

import vista.auxiliares.jugador.DisplayMapa;

import java.util.ArrayList;

public class ObservadorMapa {

    private static ObservadorMapa proxy;
    private ArrayList<DisplayMapa> diplays;

    public static ObservadorMapa getInstance(){

        if(proxy == null){

            proxy = new ObservadorMapa();

        }
        return proxy;
    }

    private ObservadorMapa(){

    }

    public void informarCambiosEnMapa(){

        this.actualizarDisplays();

    }

    public void agregarDisplay( DisplayMapa display ){

        this.diplays.add( display );

    }

    private void actualizarDisplays(){

        for ( DisplayMapa display : this.diplays ){

            display.actualizarDisplayMapa();

        }

    }

}

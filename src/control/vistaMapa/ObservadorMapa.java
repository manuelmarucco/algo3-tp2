package control.vistaMapa;

import vista.auxiliares.jugador.DisplayMapa;

import java.util.ArrayList;

public class ObservadorMapa {

    private static ObservadorMapa mapa;
    private ArrayList<DisplayMapa> diplays = new ArrayList<>();

    public static ObservadorMapa getInstance(){

        if(mapa == null){

            mapa = new ObservadorMapa();

        }
        return mapa;
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

        if (diplays != null){

            for ( DisplayMapa display : this.diplays ){

                display.actualizarDisplayMapa();

            }

        }

    }

}

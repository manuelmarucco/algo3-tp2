package vista.ventanaJugadores;

import vista.auxiliares.jugador.DisplayRecursos;

import java.util.ArrayList;

public class ObservadorRecursosSuministros {

        private static ObservadorRecursosSuministros singleton;
        private ArrayList<DisplayRecursos> diplays = new ArrayList<>();

        public static ObservadorRecursosSuministros getInstance(){

            if(singleton == null){

                singleton = new ObservadorRecursosSuministros();

            }
            return singleton;
        }

        private ObservadorRecursosSuministros(){

        }

        public void informarCambios(){

            this.actualizarDisplays();

        }

        public void agregarDisplay( DisplayRecursos display ){

            this.diplays.add( display );

        }

        private void actualizarDisplays(){

            if (diplays != null){

                for ( DisplayRecursos display : this.diplays ){

                    display.actualizarDisplayRecursos();

                }

            }

        }

}

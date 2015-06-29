package vista.sonido;


public class SonidosDelJuego {
    private static SonidosDelJuego singleton;
    private Sound sonidoEdificioEnConstruccion;
    private Sound sonidoExcepcion;
    private Sound sonidoSeleccionarEdificio;
    private Sound sonidoSeleccionarUnidad;
    private Sound sonidoUnidadCreada;

    public static SonidosDelJuego getInstance(){

        if(singleton == null){

            singleton = new SonidosDelJuego();

        }
        return singleton;
    }

    private SonidosDelJuego(){
        sonidoEdificioEnConstruccion = new Sound("sounds/construcciones/edificioEnConstruccion.wav");
        sonidoExcepcion = new Sound("sounds/excepciones/excepcionLanzadaGeneral.wav");
        sonidoSeleccionarUnidad = new Sound("sounds/unidades/seleccionarUnidad.wav");
        sonidoSeleccionarEdificio = new Sound("sounds/construcciones/seleccionarConstruccion.wav");
        sonidoUnidadCreada = new Sound("sounds/unidades/unidadCreada.wav");
    }


    public void reproducirEdificioEnConstruccion() {
        sonidoEdificioEnConstruccion.playSingleTime();
    }

    public void reproducirError() {

        sonidoExcepcion.playSingleTime();
    }

    public void reproducirSeleccionarUnidad() {
        sonidoSeleccionarUnidad.playSingleTime();
    }

    public void reproducirSeleccionarConstruccion() {
        sonidoSeleccionarEdificio.playSingleTime();
    }

    public void reproducirUnidadEntrenada(){
        sonidoUnidadCreada.playSingleTime();

    }
}

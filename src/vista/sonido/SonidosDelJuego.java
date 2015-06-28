package vista.sonido;


public class SonidosDelJuego {
    private static SonidosDelJuego singleton;

    public static SonidosDelJuego getInstance(){

        if(singleton == null){

            singleton = new SonidosDelJuego();

        }
        return singleton;
    }

    private SonidosDelJuego(){

    }


    public void reproducirEdificioEnConstruccion() {
        Sound sonido = new Sound("sounds/construcciones/edificioEnConstruccion.wav");
        sonido.playSingleTime();
    }

    public void reproducirError() {

        Sound sonido = new Sound("sounds/excepciones/excepcionLanzadaGeneral.wav");
        sonido.playSingleTime();
    }

    public void reproducirSeleccionarUnidad() {
        Sound sonido = new Sound("sounds/unidades/seleccionarUnidad.wav");
        sonido.playSingleTime();
    }

    public void reproducirSeleccionarConstruccion() {
        Sound sonido = new Sound("sounds/construcciones/seleccionarConstruccion.wav");
        sonido.playSingleTime();
    }
}

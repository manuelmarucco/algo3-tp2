package excepciones.jugador;

public class ExcepcionNoSePudoCrearElJugador extends Exception {

    @Override
    public String getMessage(){

        return ( "No se pudo crear el jugador." );

    }

}

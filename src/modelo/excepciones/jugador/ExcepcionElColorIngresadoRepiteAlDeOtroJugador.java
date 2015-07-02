package modelo.excepciones.jugador;

public class ExcepcionElColorIngresadoRepiteAlDeOtroJugador extends ExcepcionNoSePudoCrearElJugador {

    @Override
    public String getMessage(){

        return ( "El color ingresado no esta disponible." );

    }

}

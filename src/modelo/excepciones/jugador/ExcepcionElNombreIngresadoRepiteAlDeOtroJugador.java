package modelo.excepciones.jugador;

public class ExcepcionElNombreIngresadoRepiteAlDeOtroJugador extends ExcepcionNoSePudoCrearElJugador{

    @Override
    public String getMessage(){

        return ( "El nombre ingresado no esta disponible." );

    }

}

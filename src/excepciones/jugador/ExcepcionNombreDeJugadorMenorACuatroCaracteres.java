package excepciones.jugador;

public class ExcepcionNombreDeJugadorMenorACuatroCaracteres extends ExcepcionNoSePudoCrearElJugador {

    @Override
    public String getMessage(){

        return ( "El nombre debe poseer cuatro o mas caracteres." );

    }

}

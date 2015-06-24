package excepciones.Mapa;

public class ExcepcionCasillaVacia extends Throwable {

    @Override
    public String getMessage(){

        return ( "Casilla vacia." );

    }

}

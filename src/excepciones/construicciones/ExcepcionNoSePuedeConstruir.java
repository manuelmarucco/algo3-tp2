package excepciones.construicciones;

@SuppressWarnings("serial")
public class ExcepcionNoSePuedeConstruir extends Exception {

    @Override
    public String getMessage(){

        return ( "No se pudo construir." );

    }

}

package modelo.excepciones.construcciones;

@SuppressWarnings("serial")
public class ExcepcionNoSePuedeConstruir extends Exception {

    @Override
    public String getMessage(){

        return ( "No se pudo construir." );

    }

}

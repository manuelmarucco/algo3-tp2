package modelo.excepciones.construcciones;

public class ExcepcionNoSePuedeEntrenarUnidad extends Exception {

    @Override
    public String getMessage(){

        return ( "No se pudo entrenar a la unidad." );

    }

}

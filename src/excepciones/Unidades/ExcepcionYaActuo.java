package excepciones.Unidades;

public class ExcepcionYaActuo extends Throwable {

    @Override
    public String getMessage(){

        return ( "La unidad ya actuo." );

    }

}

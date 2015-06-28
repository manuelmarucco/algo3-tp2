package excepciones.Unidades;

public class ExcepcionYaActuo extends ExcepcionDeAccionDeUnidad {

    @Override
    public String getMessage(){

        return ( "La unidad ya actuo." );

    }

}

package excepciones.Unidades;

public class ExcepcionYaSeMovioLaUnidad extends ExcepcionDeAccionDeUnidad {

    @Override
    public String getMessage(){

        return ( "La unidad ya se movio." );

    }

}

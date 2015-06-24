package excepciones.Unidades;

public class ExcepcionYaSeMovioLaUnidad extends Throwable {

    @Override
    public String getMessage(){

        return ( "La unidad ya se movio." );

    }

}

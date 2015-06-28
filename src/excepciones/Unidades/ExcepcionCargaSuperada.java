package excepciones.Unidades;

@SuppressWarnings("serial")
public class ExcepcionCargaSuperada extends ExcepcionDeAccionDeUnidad {

    @Override
    public String getMessage(){

        return ( "Carga superada." );

    }

}

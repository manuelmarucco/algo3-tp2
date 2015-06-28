package excepciones.Unidades;

@SuppressWarnings("serial")
public class ExcepcionEnergiaInsuficiente extends ExcepcionDeAccionDeUnidad {

    @Override
    public String getMessage(){

        return ( "Energia insuficiente." );

    }

}

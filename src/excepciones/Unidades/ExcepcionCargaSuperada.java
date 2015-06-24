package excepciones.Unidades;

@SuppressWarnings("serial")
public class ExcepcionCargaSuperada extends Throwable {

    @Override
    public String getMessage(){

        return ( "Carga superada." );

    }

}

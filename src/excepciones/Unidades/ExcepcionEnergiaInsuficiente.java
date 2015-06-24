package excepciones.Unidades;

@SuppressWarnings("serial")
public class ExcepcionEnergiaInsuficiente extends Throwable {

    @Override
    public String getMessage(){

        return ( "Energia insuficiente." );

    }

}

package excepciones.construicciones;

@SuppressWarnings("serial")
public class ExcepcionNecesitaConstruirAcceso extends ExcepcionNecesitaConstruirOtroEdificio {

    @Override
    public String getMessage(){

        return ( "Para construir este edificio se necesita construir un acceso." );

    }

}

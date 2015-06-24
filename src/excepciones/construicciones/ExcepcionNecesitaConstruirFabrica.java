package excepciones.construicciones;

@SuppressWarnings("serial")
public class ExcepcionNecesitaConstruirFabrica extends ExcepcionNecesitaConstruirOtroEdificio {


    @Override
    public String getMessage(){

        return ( "Para construir este edificio se necesita construir una fabrica." );

    }

}

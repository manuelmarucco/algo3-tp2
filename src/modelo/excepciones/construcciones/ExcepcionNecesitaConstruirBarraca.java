package modelo.excepciones.construcciones;

@SuppressWarnings("serial")
public class ExcepcionNecesitaConstruirBarraca extends ExcepcionNecesitaConstruirOtroEdificio {

    @Override
    public String getMessage(){

        return ( "Para construir este edificio se necesita construir una barraca." );

    }

}

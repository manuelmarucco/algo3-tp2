package excepciones.construcciones;

@SuppressWarnings("serial")
public class ExcepcionNecesitaConstruirPortalEstelar extends ExcepcionNecesitaConstruirOtroEdificio{

    @Override
    public String getMessage(){

        return ( "Para construir este edificio se necesita construir un portal estelar." );

    }

}

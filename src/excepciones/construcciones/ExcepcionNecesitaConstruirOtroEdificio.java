package excepciones.construcciones;

@SuppressWarnings("serial")
public class ExcepcionNecesitaConstruirOtroEdificio extends ExcepcionNoSePuedeConstruir {

    @Override
    public String getMessage(){

        return ( "Edificio previo requerido para la construccion de este edificio." );

    }

}

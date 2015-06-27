package excepciones.construcciones;

@SuppressWarnings("serial")
public class ExcepcionGasInsuficiente extends ExcepcionRecursosInsuficientes {

    @Override
    public String getMessage(){

        return ( "Gas insuficiente." );

    }

}

package excepciones.construicciones;

@SuppressWarnings("serial")
public class ExcepcionRecursosInsuficientes extends ExcepcionNoSePuedeConstruir {

    @Override
    public String getMessage(){

        return ( "Recursos insuficientes." );

    }

}

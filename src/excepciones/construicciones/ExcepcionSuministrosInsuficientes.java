package excepciones.construicciones;

@SuppressWarnings("serial")
public class ExcepcionSuministrosInsuficientes extends Exception{

    @Override
    public String getMessage(){

        return ( "Suministros insuficientes." );

    }

}

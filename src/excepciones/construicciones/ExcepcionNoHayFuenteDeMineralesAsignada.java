package excepciones.construicciones;

public class ExcepcionNoHayFuenteDeMineralesAsignada extends Throwable {

    @Override
    public String getMessage(){

        return ( "No hay fuente de mineral asignada." );

    }

}

package excepciones.Unidades;

public class ExcepcionMoverfueraDeRango extends Throwable {

    @Override
    public String getMessage(){

        return ( "La unidad no se puede mover a donde no ve." );

    }

}

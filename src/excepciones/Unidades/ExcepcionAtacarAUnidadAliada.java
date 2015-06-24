package excepciones.Unidades;

public class ExcepcionAtacarAUnidadAliada extends Throwable {

    @Override
    public String getMessage(){

        return ( "La unidad no puede atacar una unidad aliada." );

    }

}

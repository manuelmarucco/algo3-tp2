package excepciones.Unidades;

public class ExcepcionAtacarAUnidadAliada extends ExcepcionDeAccionDeUnidad {

    @Override
    public String getMessage(){

        return ( "La unidad no puede atacar una unidad aliada." );

    }

}

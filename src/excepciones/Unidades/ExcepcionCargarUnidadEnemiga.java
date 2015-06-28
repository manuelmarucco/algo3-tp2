package excepciones.Unidades;

public class ExcepcionCargarUnidadEnemiga extends ExcepcionDeAccionDeUnidad {

    @Override
    public String getMessage(){

        return ( "La unidad no puede cargar una unidad enemiga." );

    }

}

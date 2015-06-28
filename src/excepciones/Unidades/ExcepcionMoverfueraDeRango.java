package excepciones.Unidades;

public class ExcepcionMoverfueraDeRango extends ExcepcionDeAccionDeUnidad {

    @Override
    public String getMessage(){

        return ( "La unidad no se puede mover a fuera de su rango de movimiento." );

    }

}

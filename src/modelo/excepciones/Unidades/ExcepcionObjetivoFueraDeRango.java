package modelo.excepciones.Unidades;

@SuppressWarnings("serial")
public class ExcepcionObjetivoFueraDeRango extends ExcepcionDeAccionDeUnidad {

    @Override
    public String getMessage(){

        return ( "La accion se encuentra fuera del rango de la unidad." );

    }

}

package excepciones.Unidades;

@SuppressWarnings("serial")
public class ExcepcionObjetivoFueraDeRango extends Throwable {

    @Override
    public String getMessage(){

        return ( "La accion se encuentra fuera del rango de la unidad." );

    }

}

package modelo.excepciones.Unidades;

public class ExcepcionNoPuedeAtacarAire extends ExcepcionDeAccionDeUnidad {

    @Override
    public String getMessage(){

        return ( "La unidad no puede atacar aire." );

    }

}

package excepciones.Unidades;

public class ExcepcionNoPuedeAtacarAire extends Throwable {

    @Override
    public String getMessage(){

        return ( "La unidad no puede atacar aire." );

    }

}

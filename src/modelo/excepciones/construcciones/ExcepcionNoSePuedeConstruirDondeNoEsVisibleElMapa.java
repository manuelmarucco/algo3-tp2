package modelo.excepciones.construcciones;

/**
 * Created by home1 on 27/06/2015.
 */
public class ExcepcionNoSePuedeConstruirDondeNoEsVisibleElMapa extends ExcepcionNoSePuedeConstruir {

    @Override
    public String getMessage(){

        return ( "No se puede construir donde el mapa no es visible." );

    }
}

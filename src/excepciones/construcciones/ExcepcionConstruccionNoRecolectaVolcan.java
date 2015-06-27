package excepciones.construcciones;

public class ExcepcionConstruccionNoRecolectaVolcan extends ExcepcionNoSePuedeConstruir {

    @Override
    public String getMessage(){

        return ( "La construccion debe colocarse sobre un cristal." );

    }

}

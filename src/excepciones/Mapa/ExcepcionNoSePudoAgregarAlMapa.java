package excepciones.Mapa;

public class ExcepcionNoSePudoAgregarAlMapa extends Exception{

    @Override
    public String getMessage(){

        return ( "No se pudo agregar al mapa." );

    }
}

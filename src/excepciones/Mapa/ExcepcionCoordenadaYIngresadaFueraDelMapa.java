package excepciones.Mapa;

public class ExcepcionCoordenadaYIngresadaFueraDelMapa extends ExcepcionNoSePudoAgregarAlMapa {

    @Override
    public String getMessage(){

        return ( "Coordenada Y fuera de rango." );

    }

}

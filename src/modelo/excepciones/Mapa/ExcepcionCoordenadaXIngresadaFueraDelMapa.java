package modelo.excepciones.Mapa;

public class ExcepcionCoordenadaXIngresadaFueraDelMapa extends ExcepcionNoSePudoAgregarAlMapa {

    @Override
    public String getMessage(){

        return ( "Coordenada X fuera de rango." );

    }

}

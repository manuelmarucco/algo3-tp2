package modelo.excepciones.Mapa;

public class ExcepcionPosicionOcupada extends ExcepcionNoSePudoAgregarAlMapa {

    @Override
    public String getMessage(){

        return ( "La posicion asignada ya se encuentra ocupada." );

    }

}

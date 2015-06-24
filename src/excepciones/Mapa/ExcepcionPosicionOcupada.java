package excepciones.Mapa;

import excepciones.Mapa.ExcepcionNoSePudoAgregarAlMapa;

public class ExcepcionPosicionOcupada extends ExcepcionNoSePudoAgregarAlMapa {

    @Override
    public String getMessage(){

        return ( "La posicion asignada ya se encuentra ocupada." );

    }

}

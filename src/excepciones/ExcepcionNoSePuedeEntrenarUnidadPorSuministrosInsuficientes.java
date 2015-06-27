package excepciones;

import excepciones.construcciones.ExcepcionNoSePuedeEntrenarUnidad;

public class ExcepcionNoSePuedeEntrenarUnidadPorSuministrosInsuficientes extends ExcepcionNoSePuedeEntrenarUnidad {

    @Override
    public String getMessage(){

        return ( "No se pudo entrenar a la unidad por tener suministros insuficientes." );

    }

}

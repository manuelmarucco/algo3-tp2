package modelo.excepciones;

import modelo.excepciones.construcciones.ExcepcionNoSePuedeEntrenarUnidad;

public class ExcepcionNoSePuedeEntrenarUnidadPorRecursosInsuficientes extends ExcepcionNoSePuedeEntrenarUnidad {

    @Override
    public String getMessage(){

        return ( "No se pudo entrenar a la unidad por tener recursos insuficientes." );

    }

}

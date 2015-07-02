package modelo.excepciones.Unidades;

public class ExcepcionNoSePudoCrearUnidadPorNoTenerEspacioAlrededorDeLaUnidad extends ExcepcionDeAccionDeUnidad {
    @Override
    public String getMessage(){

        return ( "No se pudo crear el clon por no tener mas espacio libre." );

    }
}

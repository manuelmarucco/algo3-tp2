package modelo.excepciones;

public class ExcepcionNoSePudoCrearUnidadPorNoTenerEspacioAlrededorDeEdificio extends Throwable {

    @Override
    public String getMessage(){

        return ( "No se pudo entrena a la unidad por tener espacio en las inmediaciones del edificio." );

    }

}

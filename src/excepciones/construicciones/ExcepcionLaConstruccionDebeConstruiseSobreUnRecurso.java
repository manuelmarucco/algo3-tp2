package excepciones.construicciones;

import interfaces.Mostrable;

public class ExcepcionLaConstruccionDebeConstruiseSobreUnRecurso extends ExcepcionNoSePuedeConstruir implements Mostrable {

    @Override
    public String mostrarMensaje() {
        return "La construccion debe construirse sobre un recurso.";
    }
}

package vista.sonido;


public class SonidosDelJuego {
    private static SonidosDelJuego singleton;
    private Sonido sonidoEntrenarUnidad;
    private Sonido sonidoEdificioEnConstruccion;
    private Sonido sonidoExcepcion;
    private Sonido sonidoSeleccionarEdificio;
    private Sonido sonidoSeleccionarUnidad;
    private Sonido sonidoUnidadCreada;
    private Sonido sonidoAlucinacion;
    private Sonido sonidoEMP;
    private Sonido sonidoRadiacion;
    private Sonido sonidoTormentaPsicotica;
    private Sonido sonidoAtaqueUnidad;
    private Sonido sonidoEdificioConstruido;
    private Sonido sonidoEdificioInvocado;

    public static SonidosDelJuego getInstance(){

        if(singleton == null){

            singleton = new SonidosDelJuego();

        }
        return singleton;
    }

    private SonidosDelJuego(){
        sonidoEdificioEnConstruccion = new Sonido("sounds/construcciones/edificioEnConstruccion.wav");
        sonidoExcepcion = new Sonido("sounds/excepciones/excepcionLanzadaGeneral.wav");
        sonidoSeleccionarUnidad = new Sonido("sounds/unidades/seleccionarUnidad.wav");
        sonidoSeleccionarEdificio = new Sonido("sounds/construcciones/seleccionarConstruccion.wav");
        sonidoUnidadCreada = new Sonido("sounds/unidades/unidadCreada.wav");
        sonidoEntrenarUnidad = new Sonido("sounds/unidades/entrenarUnidad.wav");
        sonidoAlucinacion = new Sonido("sounds/unidades/hechizos/alucinacion.wav");
        sonidoEMP = new Sonido("sounds/unidades/hechizos/emp.wav");
        sonidoRadiacion = new Sonido("sounds/unidades/hechizos/radiacion.wav");
        sonidoTormentaPsicotica = new Sonido("sounds/unidades/hechizos/tormentaPsicotica.wav");
        sonidoAtaqueUnidad = new Sonido("sounds/unidades/ataqueUnidad.wav");
        sonidoEdificioConstruido = new Sonido("sounds/construcciones/edificioConstruido.wav");
        sonidoEdificioInvocado = new Sonido("sounds/construcciones/edificioInvocado.wav");
    }


    public void reproducirEdificioEnConstruccion() {
        sonidoEdificioEnConstruccion.playSingleTime();
    }

    public void reproducirError() {sonidoExcepcion.playSingleTime();}

    public void reproducirSeleccionarUnidad() {
        sonidoSeleccionarUnidad.playSingleTime();
    }

    public void reproducirSeleccionarConstruccion() {
        sonidoSeleccionarEdificio.playSingleTime();
    }

    public void reproducirUnidadEntrenada(){sonidoUnidadCreada.playSingleTime();}

    public void reproducirAlucionacion(){sonidoAlucinacion.playSingleTime();}

    public void reproducirEMP(){sonidoEMP.playSingleTime();}

    public void reproducirRadiacion(){sonidoRadiacion.playSingleTime();}

    public void reproducirTormentaPsicotica(){sonidoTormentaPsicotica.playSingleTime();}

    public void reproducirAtaqueUnidad() { sonidoAtaqueUnidad.playSingleTime();}

    public void reproducirEdificioConstruido() { sonidoEdificioConstruido.playSingleTime();}

    public void reproducirEdificioInvocado() { sonidoEdificioInvocado.playSingleTime();}

    public void reproducirEntrenarUnidad() { sonidoEntrenarUnidad.playSingleTime();}
}

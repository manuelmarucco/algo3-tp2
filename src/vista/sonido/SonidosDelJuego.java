package vista.sonido;


public class SonidosDelJuego {
    private static SonidosDelJuego singleton;
    private Sound sonidoEntrenarUnidad;
    private Sound sonidoEdificioEnConstruccion;
    private Sound sonidoExcepcion;
    private Sound sonidoSeleccionarEdificio;
    private Sound sonidoSeleccionarUnidad;
    private Sound sonidoUnidadCreada;
    private Sound sonidoAlucinacion;
    private Sound sonidoEMP;
    private Sound sonidoRadiacion;
    private Sound sonidoTormentaPsicotica;
    private Sound sonidoAtaqueUnidad;
    private Sound sonidoEdificioConstruido;
    private Sound sonidoEdificioInvocado;

    public static SonidosDelJuego getInstance(){

        if(singleton == null){

            singleton = new SonidosDelJuego();

        }
        return singleton;
    }

    private SonidosDelJuego(){
        sonidoEdificioEnConstruccion = new Sound("sounds/construcciones/edificioEnConstruccion.wav");
        sonidoExcepcion = new Sound("sounds/excepciones/excepcionLanzadaGeneral.wav");
        sonidoSeleccionarUnidad = new Sound("sounds/unidades/seleccionarUnidad.wav");
        sonidoSeleccionarEdificio = new Sound("sounds/construcciones/seleccionarConstruccion.wav");
        sonidoUnidadCreada = new Sound("sounds/unidades/unidadCreada.wav");
        sonidoEntrenarUnidad = new Sound("sounds/unidades/entrenarUnidad.wav");
        sonidoAlucinacion = new Sound("sounds/unidades/hechizos/alucinacion.wav");
        sonidoEMP = new Sound("sounds/unidades/hechizos/emp.wav");
        sonidoRadiacion = new Sound("sounds/unidades/hechizos/radiacion.wav");
        sonidoTormentaPsicotica = new Sound("sounds/unidades/hechizos/tormentaPsicotica.wav");
        sonidoAtaqueUnidad = new Sound("sounds/unidades/ataqueUnidad.wav");
        sonidoEdificioConstruido = new Sound("sounds/construcciones/edificioConstruido.wav");
        sonidoEdificioInvocado = new Sound("sounds/construcciones/edificioInvocado.wav");
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

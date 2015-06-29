package vista.Actions.accionesUnidades;

import excepciones.Unidades.ExcepcionDeAccionDeUnidad;
import jugabilidad.utilidadesMapa.Coordenada;
import unidades.UnidadGuerrera;
import vista.Actions.accionesVentanaJugador.WraperAccionActuar;
import vista.sonido.SonidosDelJuego;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class ActionAtacar implements MouseListener, AccionUnidad {
    private UnidadGuerrera unidad;
    private WraperAccionActuar accionActuarEnEspera;

    public ActionAtacar(UnidadGuerrera unidad, WraperAccionActuar accionActuarEnEspera) {
        this.unidad = unidad;
        this.accionActuarEnEspera = accionActuarEnEspera;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        accionActuarEnEspera.setAccionActuar(this);
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void actuarEn(Coordenada coordenada) throws ExcepcionDeAccionDeUnidad {
        unidad.atacar(coordenada);
        accionActuarEnEspera.setAccionActuar(null);
        SonidosDelJuego.getInstance().reproducirAtaqueUnidad();
    }
}

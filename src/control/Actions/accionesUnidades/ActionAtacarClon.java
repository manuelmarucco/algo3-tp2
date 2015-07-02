package control.Actions.accionesUnidades;

import modelo.excepciones.Unidades.ExcepcionDeAccionDeUnidad;
import modelo.jugabilidad.utilidadesMapa.Coordenada;
import modelo.unidades.protoss.ClonGuerrero;
import control.Actions.accionesVentanaJugador.WraperAccionActuar;
import vista.sonido.SonidosDelJuego;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class ActionAtacarClon implements MouseListener, AccionUnidad {
    private ClonGuerrero unidad;
    private WraperAccionActuar accionActuarEnEspera;

    public ActionAtacarClon(ClonGuerrero unidad, WraperAccionActuar accionActuarEnEspera) {
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

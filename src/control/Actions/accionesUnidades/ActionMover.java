package control.Actions.accionesUnidades;

import modelo.excepciones.Mapa.ExcepcionNoSePudoAgregarAlMapa;
import modelo.excepciones.Unidades.ExcepcionDeAccionDeUnidad;
import modelo.jugabilidad.utilidadesMapa.Coordenada;
import modelo.unidades.Unidad;
import control.Actions.accionesVentanaJugador.WraperAccionActuar;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class ActionMover implements MouseListener, AccionUnidad {
    private Unidad unidad;
    private WraperAccionActuar accionActuarEnEspera;

    public ActionMover(Unidad unidad, WraperAccionActuar accionActuarEnEspera) {
        this.unidad = unidad;
        this.accionActuarEnEspera = accionActuarEnEspera;
    }


    @Override
    public void actuarEn(Coordenada coordenada) throws ExcepcionDeAccionDeUnidad, ExcepcionNoSePudoAgregarAlMapa {
        accionActuarEnEspera.setAccionActuar(null);
        unidad.mover(coordenada);
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
}

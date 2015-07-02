package control.Actions.accionesUnidades;

import modelo.excepciones.Mapa.ExcepcionNoSePudoAgregarAlMapa;
import modelo.excepciones.Unidades.ExcepcionDeAccionDeUnidad;
import modelo.jugabilidad.utilidadesMapa.Coordenada;
import modelo.unidades.UnidadTransporte;
import control.Actions.accionesVentanaJugador.WraperAccionActuar;
import vista.auxiliares.jugador.observadores.ObservadorEstado;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class ActionDescargar implements MouseListener, AccionUnidad {
    private UnidadTransporte unidad;
    private WraperAccionActuar wraperAccionActuar;

    public ActionDescargar(UnidadTransporte unidad, WraperAccionActuar wraperAccionActuar) {
        this.unidad = unidad;
        this.wraperAccionActuar = wraperAccionActuar;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        wraperAccionActuar.setAccionActuar(this);
        ObservadorEstado.getInstance().informarCambios();
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
    public void actuarEn(Coordenada coordenada) throws ExcepcionDeAccionDeUnidad, ExcepcionNoSePudoAgregarAlMapa {
        unidad.descargar(coordenada);
        wraperAccionActuar.setAccionActuar(null);
    }
}

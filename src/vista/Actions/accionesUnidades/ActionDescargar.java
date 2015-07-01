package vista.Actions.accionesUnidades;

import excepciones.Mapa.ExcepcionNoSePudoAgregarAlMapa;
import excepciones.Unidades.ExcepcionDeAccionDeUnidad;
import jugabilidad.utilidadesMapa.Coordenada;
import unidades.UnidadTransporte;
import vista.Actions.accionesVentanaJugador.WraperAccionActuar;
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

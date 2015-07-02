package control.Actions.accionesUnidades;

import modelo.excepciones.Unidades.ExcepcionDeAccionDeUnidad;
import modelo.jugabilidad.RazaDeJugador.JugadorProtoss;
import modelo.jugabilidad.utilidadesMapa.Coordenada;
import modelo.unidades.ProxyDeHechizos;
import modelo.unidades.protoss.AltoTemplario;
import control.Actions.accionesVentanaJugador.WraperAccionActuar;
import vista.sonido.SonidosDelJuego;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class ActionTormentaPsionica implements MouseListener, AccionUnidad {
    private AltoTemplario unidad;
    private WraperAccionActuar wraperAccionActuar;

    public ActionTormentaPsionica(AltoTemplario unidad, WraperAccionActuar wraperAccionActuar) {
        this.unidad = unidad;
        this.wraperAccionActuar = wraperAccionActuar;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        wraperAccionActuar.setAccionActuar(this);
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
        unidad.tormentaPsionica(coordenada, (JugadorProtoss) ProxyDeHechizos.obtenerDuenio(unidad));
        wraperAccionActuar.setAccionActuar(null);
        SonidosDelJuego.getInstance().reproducirTormentaPsicotica();
    }
}

package vista.Actions.accionesUnidades;

import modelo.excepciones.Mapa.ExcepcionCasillaVacia;
import modelo.excepciones.Unidades.ExcepcionDeAccionDeUnidad;
import modelo.excepciones.construcciones.ExcepcionNoSePuedeClonarEdificio;
import modelo.jugabilidad.utilidadesMapa.Coordenada;
import modelo.unidades.protoss.AltoTemplario;
import vista.Actions.accionesVentanaJugador.WraperAccionActuar;
import vista.sonido.SonidosDelJuego;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class ActionAlucinacion implements MouseListener, AccionUnidad {
    private AltoTemplario unidad;
    private WraperAccionActuar wraperAccionActuar;

    public ActionAlucinacion(AltoTemplario unidad, WraperAccionActuar wraperAccionActuar) {
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
    public void actuarEn(Coordenada coordenada) throws ExcepcionDeAccionDeUnidad, ExcepcionCasillaVacia, ExcepcionNoSePuedeClonarEdificio {
        unidad.alucinacion(coordenada);
        wraperAccionActuar.setAccionActuar(null);
        SonidosDelJuego.getInstance().reproducirAlucionacion();
    }
}

package vista.Actions.accionesUnidades;

import excepciones.Unidades.ExcepcionObjetivoFueraDeRango;
import excepciones.Unidades.ExcepcionYaActuo;
import jugabilidad.RazaDeJugador.JugadorProtoss;
import jugabilidad.utilidadesMapa.Coordenadas;
import unidades.ProxyDeHechizos;
import unidades.protoss.AltoTemplario;
import vista.Actions.WraperAccionActuar;

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
    public void actuarEn(Coordenadas coordenada) throws ExcepcionObjetivoFueraDeRango, ExcepcionYaActuo {
        unidad.tormentaPsionica(coordenada, (JugadorProtoss) ProxyDeHechizos.obtenerDuenio(unidad));
        wraperAccionActuar.setAccionActuar(null);
    }
}

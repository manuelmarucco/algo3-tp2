package vista.Actions.accionesObtenerInfoDeUnidad;

import recursos.Recurso;
import vista.ventanaJugadores.VentanaJugador;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MouseActionObtenerInfoRecurso implements MouseListener {
    private final VentanaJugador ventanaJugador;
    private final Recurso recurso;

    public MouseActionObtenerInfoRecurso(Recurso recurso, VentanaJugador ventanaJugador){
        this.recurso=recurso;
        this.ventanaJugador=ventanaJugador;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getButton()!=MouseEvent.BUTTON1) return;
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

package vista.Actions;

import unidades.terrran.Espectro;
import vista.ventanaJugadores.VentanaJugador;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MouseActionObtenerInfoEspectro implements MouseListener {
    public MouseActionObtenerInfoEspectro(Espectro unidad, VentanaJugador ventanaJugador) {
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getButton()!=MouseEvent.BUTTON1) return;
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

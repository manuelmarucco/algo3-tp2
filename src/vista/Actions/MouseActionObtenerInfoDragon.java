package vista.Actions;

import unidades.protoss.Dragon;
import vista.ventanaJugadores.VentanaJugador;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MouseActionObtenerInfoDragon implements MouseListener {
    private final Dragon dragon;
    private final VentanaJugador ventanaJugador;

    public MouseActionObtenerInfoDragon(Dragon unidad, VentanaJugador ventanaJugador) {
        this.dragon=unidad;
        this.ventanaJugador=ventanaJugador;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getButton()!=MouseEvent.BUTTON1)return;

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

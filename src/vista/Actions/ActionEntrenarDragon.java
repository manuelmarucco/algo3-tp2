package vista.Actions;

import construcciones.protoss.Acceso;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class ActionEntrenarDragon implements MouseListener {
    private final Acceso acceso;

    public ActionEntrenarDragon(Acceso unidad) {
        this.acceso= unidad;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getButton()!=MouseEvent.BUTTON1) return;
        this.acceso.entrenarDragon();
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

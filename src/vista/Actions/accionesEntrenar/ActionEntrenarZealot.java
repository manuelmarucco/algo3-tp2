package vista.Actions.accionesEntrenar;

import construcciones.protoss.Acceso;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class ActionEntrenarZealot implements MouseListener {
    private final Acceso acceso;

    public ActionEntrenarZealot(Acceso unidad) {
        this.acceso= unidad;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getButton()!=MouseEvent.BUTTON1) return;
        this.acceso.entrenarZealot();
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

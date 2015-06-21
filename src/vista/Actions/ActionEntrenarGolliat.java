package vista.Actions;

import construcciones.terran.Fabrica;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class ActionEntrenarGolliat implements MouseListener {
    private final Fabrica fabrica;

    public ActionEntrenarGolliat(Fabrica unidad) {
        this.fabrica=unidad;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getButton()!=MouseEvent.BUTTON1) return;
        this.fabrica.entrenarGolliat();
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

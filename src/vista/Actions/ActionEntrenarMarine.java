package vista.Actions;

import construcciones.terran.Barraca;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class ActionEntrenarMarine implements MouseListener {
    private final Barraca barraca;

    public ActionEntrenarMarine(Barraca unidad) {
        this.barraca=unidad;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getButton()!=MouseEvent.BUTTON1) return;
        this.barraca.entrenarMarine();
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

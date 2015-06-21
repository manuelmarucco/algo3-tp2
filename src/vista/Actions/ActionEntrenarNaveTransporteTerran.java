package vista.Actions;

import construcciones.terran.PuertoEstelar;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class ActionEntrenarNaveTransporteTerran implements MouseListener {
    private final PuertoEstelar puertoEstelar;

    public ActionEntrenarNaveTransporteTerran(PuertoEstelar unidad) {
        this.puertoEstelar=unidad;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getButton()!=MouseEvent.BUTTON1) return;
        puertoEstelar.entrenarNaveTransporte();
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

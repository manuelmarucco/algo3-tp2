package vista.Actions.accionesEntrenar;

import construcciones.terran.PuertoEstelar;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class ActionEntrenarEsprectro implements MouseListener {
    private final PuertoEstelar puertoEstelar;

    public ActionEntrenarEsprectro(PuertoEstelar unidad) {
        this.puertoEstelar=unidad;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getButton()!=MouseEvent.BUTTON1) return;
        puertoEstelar.entrenarEspectro();
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

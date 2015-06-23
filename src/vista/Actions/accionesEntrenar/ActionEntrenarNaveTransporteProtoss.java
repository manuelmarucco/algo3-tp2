package vista.Actions.accionesEntrenar;

import construcciones.protoss.PortalEstelar;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class ActionEntrenarNaveTransporteProtoss implements MouseListener {

    private PortalEstelar portalEstelar;

    public ActionEntrenarNaveTransporteProtoss(PortalEstelar unidad) {
        this.portalEstelar=unidad;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getButton()!=MouseEvent.BUTTON1) return;
        this.portalEstelar.entrenarNaveTransporte();
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

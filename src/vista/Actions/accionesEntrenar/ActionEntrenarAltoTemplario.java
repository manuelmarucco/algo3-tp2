package vista.Actions.accionesEntrenar;

import construcciones.protoss.ArchivosTemplarios;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class ActionEntrenarAltoTemplario implements MouseListener {
    private ArchivosTemplarios archivosTemplarios;
    public ActionEntrenarAltoTemplario(ArchivosTemplarios unidad) {
        this.archivosTemplarios=unidad;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getButton()!=MouseEvent.BUTTON1) return;
        this.archivosTemplarios.entrenarAltoTemplario();
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

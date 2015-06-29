package vista.Actions.accionesEntrenar;

import construcciones.protoss.ArchivosTemplarios;
import control.ObservadorDeExcepciones;
import excepciones.construcciones.ExcepcionNoSePuedeEntrenarUnidad;
import vista.sonido.SonidosDelJuego;
import vista.ventanaJugadores.ObservadorEstado;
import vista.ventanaJugadores.ObservadorRecursosSuministros;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class ActionEntrenarAltoTemplario implements MouseListener {
    private ArchivosTemplarios archivosTemplarios;
    public ActionEntrenarAltoTemplario(ArchivosTemplarios unidad) {
        this.archivosTemplarios=unidad;
    }

    @Override
    public void mouseClicked(MouseEvent m) {
        if (m.getButton()!=MouseEvent.BUTTON1) return;

        try {
            this.archivosTemplarios.entrenarAltoTemplario();

            System.out.println("Alto Templario en entrenamiento");
            SonidosDelJuego.getInstance().reproducirUnidadEntrenada();
            ObservadorRecursosSuministros.getInstance().informarCambios();
            ObservadorEstado.getInstance().informarCambios();

        } catch (ExcepcionNoSePuedeEntrenarUnidad e) {
            ObservadorDeExcepciones.getInstance().informarNuevaExcepcion(e);
        }
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

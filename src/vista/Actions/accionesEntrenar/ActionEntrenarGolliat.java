package vista.Actions.accionesEntrenar;

import construcciones.terran.Fabrica;
import control.ObservadorDeExcepciones;
import excepciones.construicciones.ExcepcionNoSePuedeEntrenarUnidad;
import vista.ventanaJugadores.ObservadorRecursosSuministros;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class ActionEntrenarGolliat implements MouseListener {
    private final Fabrica fabrica;

    public ActionEntrenarGolliat(Fabrica unidad) {
        this.fabrica=unidad;
    }

    @Override
    public void mouseClicked(MouseEvent m) {
        if (m.getButton()!=MouseEvent.BUTTON1) return;
        try {
            this.fabrica.entrenarGolliat();
            System.out.println("Golliat en entrenamiento");
            ObservadorRecursosSuministros.getInstance().informarCambios();

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

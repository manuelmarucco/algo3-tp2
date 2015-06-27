package vista.Actions.accionesEntrenar;

import construcciones.terran.PuertoEstelar;
import control.ObservadorDeExcepciones;
import excepciones.construcciones.ExcepcionNoSePuedeEntrenarUnidad;
import vista.ventanaJugadores.ObservadorEstado;
import vista.ventanaJugadores.ObservadorRecursosSuministros;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class ActionEntrenarNaveTransporteTerran implements MouseListener {
    private final PuertoEstelar puertoEstelar;

    public ActionEntrenarNaveTransporteTerran(PuertoEstelar unidad) {
        this.puertoEstelar=unidad;
    }

    @Override
    public void mouseClicked(MouseEvent m) {
        if(m.getButton()!=MouseEvent.BUTTON1) return;
        try {
            puertoEstelar.entrenarNaveTransporte();
        System.out.println("NaveTransporte en entrenamiento");
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

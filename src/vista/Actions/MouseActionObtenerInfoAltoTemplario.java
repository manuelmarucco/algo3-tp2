package vista.Actions;

import unidades.protoss.AltoTemplario;
import vista.panelesDeEstado.panelesDeUnidad.PanelUnidadMagica;
import vista.ventanaJugadores.VentanaJugador;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MouseActionObtenerInfoAltoTemplario implements MouseListener {
    private final AltoTemplario altoTemplario;
    private final VentanaJugador ventanaJugador;
    private PanelUnidadMagica panelDeUnidad;

    public MouseActionObtenerInfoAltoTemplario(AltoTemplario unidad, VentanaJugador ventanaJugador) {
        this.altoTemplario=unidad;
        this.ventanaJugador=ventanaJugador;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getButton()!=MouseEvent.BUTTON1)return;

        this.panelDeUnidad = new PanelUnidadMagica();

        this.cargarInfoAlPanel();

        ventanaJugador.mostrarPanelDeEstado(panelDeUnidad,"Center");

    }

    private void cargarInfoAlPanel() {

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

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
        this.panelDeUnidad = new PanelUnidadMagica();
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getButton()!=MouseEvent.BUTTON1)return;

        this.cargarInfoAlPanelDeEstado();
        ventanaJugador.borrarPanelDeEstadoAnterior();
        ventanaJugador.mostrarPanelDeEstado(panelDeUnidad);
        ventanaJugador.getPanelAcciones().configurarBotones(altoTemplario);

    }

    private void cargarInfoAlPanelDeEstado() {

        this.panelDeUnidad.setNombre(altoTemplario.getClass().toString());
        this.panelDeUnidad.setVida(String.valueOf(altoTemplario.getVida()));
        this.panelDeUnidad.setEnergiaTotal(String.valueOf(altoTemplario.getEnergia().getEnergiaTotal()));
        this.panelDeUnidad.setEnergiaActual(String.valueOf(altoTemplario.getEnergiaActual()));
        this.panelDeUnidad.setVision(String.valueOf(altoTemplario.getVision()));
        this.panelDeUnidad.setEscudo(String.valueOf(altoTemplario.getEscudo()));
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

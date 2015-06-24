package vista.Actions.accionesObtenerInfoDeUnidad;

import unidades.terrran.Marine;
import vista.panelesDeEstado.panelesDeUnidad.PanelUnidadGuerrera;
import vista.ventanaJugadores.VentanaJugador;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MouseActionObtenerInfoMarine implements MouseListener {
    private final Marine marine;
    private final VentanaJugador ventanaJugador;
    private PanelUnidadGuerrera panelDeUnidad;

    public MouseActionObtenerInfoMarine(Marine unidad, VentanaJugador ventanaJugador) {
        this.marine=unidad;
        this.ventanaJugador = ventanaJugador;
        this.panelDeUnidad = new PanelUnidadGuerrera();
    }

    @Override
    public void mouseClicked(MouseEvent e) {
       // if(e.getButton()!=MouseEvent.BUTTON1)return;
       // if(e.getButton()==MouseEvent.BUTTON1) {
         //   ventanaJugador.borrarPanelDeEstadoAnterior();
         //   this.cargarInfoAlPanelDeEstado();
          //  ventanaJugador.mostrarPanelDeEstado(panelDeUnidad);
          //  ventanaJugador.getPanelAcciones().configurarBotones(marine);

       // }
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
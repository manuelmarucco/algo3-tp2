package vista.Actions.accionesObtenerInfoDeUnidad;

import unidades.terrran.Espectro;
import vista.panelesDeEstado.panelesDeUnidad.PanelUnidadGuerrera;
import vista.ventanaJugadores.VentanaJugador;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MouseActionObtenerInfoEspectro implements MouseListener {
    private final Espectro espectro;
    private final VentanaJugador ventanaJugador;
    private PanelUnidadGuerrera panelDeUnidad;
    
    public MouseActionObtenerInfoEspectro(Espectro unidad, VentanaJugador ventanaJugador) {
        this.espectro=unidad;
        this.ventanaJugador=ventanaJugador;
        this.panelDeUnidad = new PanelUnidadGuerrera();
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getButton()!=MouseEvent.BUTTON1)return;

        this.cargarInfoAlPanelDeEstado();
        ventanaJugador.borrarPanelDeEstadoAnterior();
        ventanaJugador.mostrarPanelDeEstado(panelDeUnidad);
        ventanaJugador.getPanelAcciones().configurarBotones(espectro);
    }

    private void cargarInfoAlPanelDeEstado() {

        this.panelDeUnidad.setNombre(espectro.getClass().toString());
        this.panelDeUnidad.setVida(String.valueOf(espectro.getVida()));
        this.panelDeUnidad.setVision(String.valueOf(espectro.getVision()));
        this.panelDeUnidad.setDanioTerrestre(String.valueOf(espectro.getDanioTerrestre()));
        this.panelDeUnidad.setDanioAereo(String.valueOf(espectro.getDanioAereo()));
        this.panelDeUnidad.setRangoAtaqueTerrestre(String.valueOf(espectro.getRangoTerrestre()));
        this.panelDeUnidad.setRangoAtaqueAereo(String.valueOf(espectro.getRangoAereo()));
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

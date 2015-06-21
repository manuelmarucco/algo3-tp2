package vista.Actions;

import unidades.protoss.Dragon;
import vista.panelesDeEstado.panelesDeUnidad.PanelUnidadGuerrera;
import vista.ventanaJugadores.VentanaJugador;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MouseActionObtenerInfoDragon implements MouseListener {
    private final Dragon dragon;
    private final VentanaJugador ventanaJugador;
    private PanelUnidadGuerrera panelDeUnidad;

    public MouseActionObtenerInfoDragon(Dragon unidad, VentanaJugador ventanaJugador) {
        this.dragon=unidad;
        this.ventanaJugador=ventanaJugador;
        this.panelDeUnidad = new PanelUnidadGuerrera();
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getButton()!=MouseEvent.BUTTON1)return;

        this.cargarInfoAlPanelDeEstado();
        ventanaJugador.borrarPanelDeEstadoAnterior();
        ventanaJugador.mostrarPanelDeEstado(panelDeUnidad);
        ventanaJugador.getPanelAcciones().configurarBotones(dragon);

    }

    private void cargarInfoAlPanelDeEstado() {

        this.panelDeUnidad.setNombre(dragon.getClass().toString());
        this.panelDeUnidad.setVida(String.valueOf(dragon.getVida()));
        this.panelDeUnidad.setVision(String.valueOf(dragon.getVision()));
        this.panelDeUnidad.setEscudo(String.valueOf(dragon.getEscudo()));
        this.panelDeUnidad.setDanioTerrestre(String.valueOf(dragon.getDanioTerrestre()));
        this.panelDeUnidad.setDanioAereo(String.valueOf(dragon.getDanioAereo()));
        this.panelDeUnidad.setRangoAtaqueTerrestre(String.valueOf(dragon.getRangoTerrestre()));
        this.panelDeUnidad.setRangoAtaqueAereo(String.valueOf(dragon.getRangoAereo()));
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

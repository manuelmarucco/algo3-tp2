package vista.unidades;

import interfaces.ColocableEnMapa;
import unidades.protoss.Dragon;
import vista.IVista;
import vista.auxiliares.ImagePanel;
import vista.panelesDeEstado.panelesDeUnidad.PanelUnidadGuerrera;
import vista.ventanaJugadores.VentanaJugador;

import javax.swing.*;

public class VistaDragon extends ImagePanel implements IVista {
    private static final int ANCHO = 64;
    private static final int ALTO = 64;
    private final Dragon dragon;
    private final VentanaJugador ventanaJugador;
    private static String pathImagen="images/unidades/protoss/dragon.png";

    public VistaDragon(ColocableEnMapa dragon,VentanaJugador ventanaJugador) {
        super(ANCHO,ALTO,new ImageIcon(pathImagen).getImage().getScaledInstance(ANCHO, ALTO, java.awt.Image.SCALE_SMOOTH));
        super.setBackground(new ImageIcon("src/vista/paisaje/imagenes/pasto.png").getImage());
        this.dragon=(Dragon)dragon;
        this.ventanaJugador=ventanaJugador;
    }

    @Override
    public void actualizarBotonera() {
        ventanaJugador.getPanelAcciones().configurarBotones(dragon);
    }

    @Override
    public void actualizarPanelEstado() {
        PanelUnidadGuerrera panelDeUnidad = new PanelUnidadGuerrera();

        ventanaJugador.borrarPanelDeEstadoAnterior();
        this.cargarInfoAlPanelDeEstado(panelDeUnidad);
        ventanaJugador.mostrarPanelDeEstado(panelDeUnidad);

    }

    private void cargarInfoAlPanelDeEstado(PanelUnidadGuerrera panelDeUnidad) {

        panelDeUnidad.setNombre(dragon.getClass().toString());
        panelDeUnidad.setVida(String.valueOf(dragon.getVida()));
        panelDeUnidad.setVision(String.valueOf(dragon.getVision()));
        panelDeUnidad.setEscudo(String.valueOf(dragon.getEscudo()));
        panelDeUnidad.setDanioTerrestre(String.valueOf(dragon.getDanioTerrestre()));
        panelDeUnidad.setDanioAereo(String.valueOf(dragon.getDanioAereo()));
        panelDeUnidad.setRangoAtaqueTerrestre(String.valueOf(dragon.getRangoTerrestre()));
        panelDeUnidad.setRangoAtaqueAereo(String.valueOf(dragon.getRangoAereo()));
    }
}

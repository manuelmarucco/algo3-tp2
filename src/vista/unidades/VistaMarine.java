package vista.unidades;

import interfaces.ColocableEnMapa;
import unidades.terrran.Marine;
import vista.IVista;
import vista.auxiliares.ImagePanel;
import vista.panelesDeEstado.panelesDeUnidad.PanelUnidadGuerrera;
import vista.ventanaJugadores.VentanaJugador;

import javax.swing.*;

public class VistaMarine extends ImagePanel implements IVista{

    private static final int ANCHO = 64;
    private static final int ALTO = 64;
    private final Marine marine;
    private static String pathImagen="images/unidades/terrran/marine.png";
    private final VentanaJugador ventanaJugador;

    public VistaMarine(ColocableEnMapa marine,VentanaJugador ventanaJugador) {
        super(ANCHO,ALTO,new ImageIcon(pathImagen).getImage().getScaledInstance(ANCHO, ALTO, java.awt.Image.SCALE_SMOOTH));
        super.setBackground(new ImageIcon("src/vista/paisaje/imagenes/pasto.png").getImage());
        this.marine= (Marine) marine;
        this.ventanaJugador=ventanaJugador;
    }

    @Override
    public void actualizarBotonera() {
        ventanaJugador.getPanelAcciones().configurarBotones(marine);
    }

    @Override
    public void actualizarPanelEstado() {
        PanelUnidadGuerrera panelDeUnidad = new PanelUnidadGuerrera();

        ventanaJugador.borrarPanelDeEstadoAnterior();
        this.cargarInfoAlPanelDeEstado(panelDeUnidad);
        ventanaJugador.mostrarPanelDeEstado(panelDeUnidad);

    }

    private void cargarInfoAlPanelDeEstado(PanelUnidadGuerrera panelDeUnidad) {

        panelDeUnidad.setNombre("Marine");
        panelDeUnidad.setVida(String.valueOf(marine.getVida()));
        panelDeUnidad.setVision(String.valueOf(marine.getVision()));
        panelDeUnidad.setDanioTerrestre(String.valueOf(marine.getDanioTerrestre()));
        panelDeUnidad.setDanioAereo(String.valueOf(marine.getDanioAereo()));
        panelDeUnidad.setRangoAtaqueTerrestre(String.valueOf(marine.getRangoTerrestre()));
        panelDeUnidad.setRangoAtaqueAereo(String.valueOf(marine.getRangoAereo()));
    }
}
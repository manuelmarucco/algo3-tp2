package vista.unidades;

import control.BufferImagenes;
import interfaces.ColocableEnMapa;
import unidades.terrran.Espectro;
import vista.IVista;
import vista.auxiliares.ImagePanel;
import vista.panelesDeEstado.panelesDeUnidad.PanelUnidadGuerrera;
import vista.ventanaJugadores.VentanaJugador;

import javax.swing.*;
import java.awt.*;

public class VistaEspectro extends ImagePanel implements IVista{
    private static final int ANCHO = 64;
    private static final int ALTO = 64;
    private final Espectro espectro;
    private final VentanaJugador ventanaJugador;
    private static final BufferImagenes BUFFERIMAGENES = new BufferImagenes();

    public VistaEspectro(ColocableEnMapa espectro,VentanaJugador ventanaJugador) {
        super(ANCHO, ALTO, BUFFERIMAGENES.obtenerImagen("Espectro").getImage().getScaledInstance(ANCHO, ALTO, Image.SCALE_FAST));
        this.espectro=(Espectro)espectro;
        this.ventanaJugador = ventanaJugador;
    }

    @Override
    public void actualizarBotonera() {
        ventanaJugador.getPanelAcciones().configurarBotones(espectro);
    }

    @Override
    public void actualizarPanelEstado() {
        PanelUnidadGuerrera panelDeUnidad = new PanelUnidadGuerrera();

        this.cargarInfoAlPanelDeEstado(panelDeUnidad);
        ventanaJugador.borrarPanelDeEstadoAnterior();
        ventanaJugador.mostrarPanelDeEstado(panelDeUnidad);
}

    private void cargarInfoAlPanelDeEstado(PanelUnidadGuerrera panelDeUnidad ) {

        panelDeUnidad.setNombre(espectro.getClass().toString());
        panelDeUnidad.setVida(String.valueOf(espectro.getVida()));
        panelDeUnidad.setVision(String.valueOf(espectro.getVision()));
        panelDeUnidad.setDanioTerrestre(String.valueOf(espectro.getDanioTerrestre()));
        panelDeUnidad.setDanioAereo(String.valueOf(espectro.getDanioAereo()));
        panelDeUnidad.setRangoAtaqueTerrestre(String.valueOf(espectro.getRangoTerrestre()));
        panelDeUnidad.setRangoAtaqueAereo(String.valueOf(espectro.getRangoAereo()));
    }
}

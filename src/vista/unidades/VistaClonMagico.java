package vista.unidades;

import control.BufferImagenes;
import interfaces.ColocableEnMapa;
import unidades.protoss.ClonMagico;
import vista.IVista;
import vista.auxiliares.ImagePanel;
import vista.panelesDeEstado.panelesDeUnidad.PanelUnidadMagica;
import vista.ventanaJugadores.VentanaJugador;

import java.awt.*;

public class VistaClonMagico extends ImagePanel implements IVista {
    private static final int ANCHO = 64;
    private static final int ALTO = 64;
    private final ClonMagico clonMagico;
    private final VentanaJugador ventanaJugador;
    private static final BufferImagenes BUFFERIMAGENES = new BufferImagenes();

    public VistaClonMagico(ColocableEnMapa clonMagico,VentanaJugador ventanaJugador) {
        super(ANCHO, ALTO, BUFFERIMAGENES.obtenerImagen(((ClonMagico) clonMagico).getUnidad().getClass().getSimpleName()).getImage().getScaledInstance(ANCHO, ALTO, Image.SCALE_FAST));
        super.setBackground( BUFFERIMAGENES.obtenerImagen("Pasto").getImage());
        this.clonMagico=(ClonMagico)clonMagico;
        this.ventanaJugador=ventanaJugador;
    }

    @Override
    public void actualizarBotonera() {
        ventanaJugador.getPanelAcciones().configurarBotones(clonMagico);
    }

    @Override
    public void actualizarPanelEstado() {
        PanelUnidadMagica panelDeUnidad = new PanelUnidadMagica();

        ventanaJugador.borrarPanelDeEstadoAnterior();
        this.cargarInfoAlPanelDeEstado(panelDeUnidad);
        ventanaJugador.mostrarPanelDeEstado(panelDeUnidad);

    }

    private void cargarInfoAlPanelDeEstado(PanelUnidadMagica panelDeUnidad) {

        panelDeUnidad.setNombre(clonMagico.getClass().toString());
        panelDeUnidad.setVida(String.valueOf(0));
        panelDeUnidad.setEnergiaTotal(String.valueOf(clonMagico.getEnergia().getEnergiaTotal()));
        panelDeUnidad.setEnergiaActual(String.valueOf(clonMagico.getEnergiaActual()));
        panelDeUnidad.setVision(String.valueOf(clonMagico.getVision()));
        panelDeUnidad.setEscudo(String.valueOf(clonMagico.getEscudo()));
    }
}
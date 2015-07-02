package vista.unidades;

import control.BufferImagenes;
import modelo.interfaces.ColocableEnMapa;
import modelo.unidades.protoss.AltoTemplario;
import vista.IVista;
import vista.auxiliares.ImagePanel;
import vista.panelesDeEstado.panelesDeUnidad.PanelUnidadMagica;
import vista.ventanaJugadores.VentanaJugador;

import java.awt.*;

public class VistaAltoTemplario extends ImagePanel implements IVista{
    private static final int ANCHO = 64;
    private static final int ALTO = 64;
    private final AltoTemplario altoTemplario;
    private final VentanaJugador ventanaJugador;
    private static final BufferImagenes BUFFERIMAGENES = BufferImagenes.getInstance();

    public VistaAltoTemplario(ColocableEnMapa altoTemplario,VentanaJugador ventanaJugador) {
        super(ANCHO, ALTO, BUFFERIMAGENES.obtenerImagen("AltoTemplario").getImage().getScaledInstance(ANCHO, ALTO, Image.SCALE_FAST));
        super.setBackground( BUFFERIMAGENES.obtenerImagen("Pasto").getImage());
        this.altoTemplario=(AltoTemplario)altoTemplario;
        this.ventanaJugador=ventanaJugador;
    }

    @Override
    public void actualizarBotonera() {
        ventanaJugador.getPanelAcciones().configurarBotones(altoTemplario);
    }

    @Override
    public void actualizarPanelEstado() {
        PanelUnidadMagica panelDeUnidad = new PanelUnidadMagica();

        ventanaJugador.borrarPanelDeEstadoAnterior();
        this.cargarInfoAlPanelDeEstado(panelDeUnidad);
        ventanaJugador.mostrarPanelDeEstado(panelDeUnidad);

    }

    private void cargarInfoAlPanelDeEstado(PanelUnidadMagica panelDeUnidad) {

        panelDeUnidad.setNombre(altoTemplario.getClass().getSimpleName());
        panelDeUnidad.setEnergiaTotal(String.valueOf(altoTemplario.getEnergia().getEnergiaTotal()));
        panelDeUnidad.setVision(String.valueOf(altoTemplario.getVision()));
        panelDeUnidad.setEscudo(String.valueOf(altoTemplario.getEscudo()));
        panelDeUnidad.cargarDatosActualizables(altoTemplario);
    }
}

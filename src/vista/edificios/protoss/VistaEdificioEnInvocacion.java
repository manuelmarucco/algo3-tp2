package vista.edificios.protoss;

import control.BufferImagenes;
import modelo.construcciones.protoss.EdificioEnInvocacion;
import modelo.interfaces.ColocableEnMapa;
import vista.IVista;
import vista.auxiliares.ImagePanel;
import vista.panelesDeEstado.panelesDeConstruccion.PanelEdificioEnInvocacion;
import vista.ventanaJugadores.VentanaJugador;

import javax.swing.*;
import java.awt.*;

public class VistaEdificioEnInvocacion  extends ImagePanel implements IVista {

    private static final int ANCHO = 64;
    private static final int ALTO = 64;
    private final EdificioEnInvocacion edificio;
    private final VentanaJugador ventanaJugador;
    private static final BufferImagenes BUFFERIMAGENES = BufferImagenes.getInstance();

    public VistaEdificioEnInvocacion(ColocableEnMapa edificioEnConstruccion, VentanaJugador ventanaJugador) {
        super(ANCHO,ALTO,BUFFERIMAGENES.obtenerImagen("EdificioEnInvocacion").getImage().getScaledInstance(ANCHO, ALTO, Image.SCALE_FAST));
        super.setBackground(BUFFERIMAGENES.obtenerImagen("Pasto").getImage());
        this.edificio= (EdificioEnInvocacion) edificioEnConstruccion;
        this.ventanaJugador=ventanaJugador;
    }

    @Override
    public void actualizarBotonera() {
        ventanaJugador.getPanelAcciones().limpiar();
    }

    @Override
    public void actualizarPanelEstado() {
        PanelEdificioEnInvocacion panelDeConstruccion = new PanelEdificioEnInvocacion();

        ventanaJugador.borrarPanelDeEstadoAnterior();
        this.cargarInfoAlPanelDeEstado(panelDeConstruccion);
        ventanaJugador.mostrarPanelDeEstado(panelDeConstruccion);

    }

    private void cargarInfoAlPanelDeEstado(PanelEdificioEnInvocacion panelDeConstruccion) {
        panelDeConstruccion.cargarDatosDeEdificioEnConstruccion(edificio);
    }
}

package vista.edificios.terran;

import control.BufferImagenes;
import modelo.construcciones.EdificioEnConstruccion;
import modelo.interfaces.ColocableEnMapa;
import vista.IVista;
import vista.auxiliares.ImagePanel;
import vista.panelesDeEstado.panelesDeConstruccion.PanelEdificioEnConstruccion;
import vista.ventanaJugadores.VentanaJugador;

import javax.swing.*;
import java.awt.*;

public class VistaEdificioEnConstruccion  extends ImagePanel implements IVista {

    private static final int ANCHO = 64;
    private static final int ALTO = 64;
    private final EdificioEnConstruccion edificio;
    private final VentanaJugador ventanaJugador;
    private static final BufferImagenes BUFFERIMAGENES = BufferImagenes.getInstance();

    public VistaEdificioEnConstruccion(ColocableEnMapa edificioEnConstruccion, VentanaJugador ventanaJugador) {
        super(ANCHO,ALTO,BUFFERIMAGENES.obtenerImagen("EdificioEnConstruccion").getImage().getScaledInstance(ANCHO, ALTO, Image.SCALE_FAST));
        super.setBackground(BUFFERIMAGENES.obtenerImagen("Pasto").getImage());
        this.edificio= (EdificioEnConstruccion) edificioEnConstruccion;
        this.ventanaJugador=ventanaJugador;
    }

    @Override
    public void actualizarBotonera() {
        ventanaJugador.getPanelAcciones().limpiar();
    }

    @Override
    public void actualizarPanelEstado() {
        PanelEdificioEnConstruccion panelDeConstruccion = new PanelEdificioEnConstruccion();

        ventanaJugador.borrarPanelDeEstadoAnterior();
        this.cargarInfoAlPanelDeEstado(panelDeConstruccion);
        ventanaJugador.mostrarPanelDeEstado(panelDeConstruccion);

    }

    private void cargarInfoAlPanelDeEstado(PanelEdificioEnConstruccion panelDeConstruccion) {
        panelDeConstruccion.cargarDatosDeEdificioEnConstruccion(edificio);
    }
}

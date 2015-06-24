package vista.edificios.protoss;

import construcciones.protoss.ArchivosTemplarios;
import interfaces.ColocableEnMapa;
import vista.IVista;
import vista.auxiliares.ImagePanel;
import vista.ventanaJugadores.VentanaJugador;

import javax.swing.*;

public class VistaArchivosTemplarios extends ImagePanel implements IVista{

    private static final int ANCHO = 1;
    private static final int ALTO = 2;
    private final ArchivosTemplarios edificio;
    private final VentanaJugador ventanaJugador;

    public VistaArchivosTemplarios(ColocableEnMapa archivosTemplarios, VentanaJugador ventanaJugador) {
        super(ANCHO,ALTO,new ImageIcon().getImage());
        this.edificio= (ArchivosTemplarios) archivosTemplarios;
        this.ventanaJugador=ventanaJugador;
    }

    @Override
    public void actualizarBotonera() {
        ventanaJugador.getPanelAcciones().configurarBotones(edificio);
    }

    @Override
    public void actualizarPanelEstado() {

    }
}

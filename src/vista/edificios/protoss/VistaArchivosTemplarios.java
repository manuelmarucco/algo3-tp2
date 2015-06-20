package vista.edificios.protoss;

import construcciones.protoss.ArchivosTemplarios;
import vista.auxiliares.ImagePanel;
import vista.ventanaJugadores.VentanaJugador;

import javax.swing.*;

public class VistaArchivosTemplarios extends ImagePanel{

    private static final int ANCHO = 1;
    private static final int ALTO = 2;
    private final ArchivosTemplarios edificio;
    private final VentanaJugador ventanaJugador;

    public VistaArchivosTemplarios(ArchivosTemplarios archivosTemplarios, VentanaJugador ventanaJugador) {
        super(ANCHO,ALTO,new ImageIcon().getImage());
        this.edificio=archivosTemplarios;
        this.ventanaJugador=ventanaJugador;
    }

}

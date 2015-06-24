package vista.edificios.protoss;

import construcciones.protoss.PortalEstelar;
import interfaces.ColocableEnMapa;
import vista.auxiliares.ImagePanel;
import vista.ventanaJugadores.VentanaJugador;

import javax.swing.*;

public class VistaPortalEstelar extends ImagePanel{

    private static final int ANCHO = 1;
    private static final int ALTO = 2;
    private final PortalEstelar edificio;
    private final VentanaJugador ventanaJugador;

    public VistaPortalEstelar(ColocableEnMapa portalEstelar,VentanaJugador ventanaJugador) {
        super(ANCHO,ALTO,new ImageIcon().getImage());
        this.edificio= (PortalEstelar) portalEstelar;
        this.ventanaJugador=ventanaJugador;
    }

}

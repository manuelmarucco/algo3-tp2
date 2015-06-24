package vista.edificios.terran;

import construcciones.terran.PuertoEstelar;
import interfaces.ColocableEnMapa;
import vista.auxiliares.ImagePanel;
import vista.ventanaJugadores.VentanaJugador;

import javax.swing.*;

public class VistaPuertoEstelar extends ImagePanel{

    private static final int ANCHO = 1;
    private static final int ALTO = 2;
    private final PuertoEstelar edificio;
    private final VentanaJugador ventanaJugador;

    public VistaPuertoEstelar(ColocableEnMapa puertoEstelar,VentanaJugador ventanaJugador) {
        super(ANCHO,ALTO,new ImageIcon().getImage());
        this.edificio= (PuertoEstelar) puertoEstelar;
        this.ventanaJugador=ventanaJugador;
    }

}

package vista.edificios;

import construcciones.EdificioEnConstruccion;
import interfaces.ColocableEnMapa;
import vista.auxiliares.ImagePanel;
import vista.ventanaJugadores.VentanaJugador;

import javax.swing.*;

public class VistaEdificioEnConstruccion  extends ImagePanel {

    private static final int ANCHO = 64;
    private static final int ALTO = 64;
    private final EdificioEnConstruccion edificio;
    private final VentanaJugador ventanaJugador;
    private static String imagePath="images/construicciones/terrran/edificioEnConstruccion.png";

    public VistaEdificioEnConstruccion(ColocableEnMapa edificioEnConstruccion, VentanaJugador ventanaJugador) {
        super(ANCHO,ALTO,new ImageIcon(imagePath).getImage().getScaledInstance(ANCHO, ALTO,  java.awt.Image.SCALE_SMOOTH));
        this.edificio= (EdificioEnConstruccion) edificioEnConstruccion;
        this.ventanaJugador=ventanaJugador;
    }
}

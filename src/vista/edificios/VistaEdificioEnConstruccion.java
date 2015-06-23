package vista.edificios;

import construcciones.EdificioEnConstruccion;
import vista.auxiliares.ImagePanel;
import vista.ventanaJugadores.VentanaJugador;

import javax.swing.*;

public class VistaEdificioEnConstruccion  extends ImagePanel {

    private static final int ANCHO = 64;
    private static final int ALTO = 64;
    private final EdificioEnConstruccion edificio;
    private final VentanaJugador ventanaJugador;
    private static String imagePath="images/construicciones/terrran/edificioEnConstruccion.png";

    public VistaEdificioEnConstruccion(EdificioEnConstruccion edificioEnConstruccion, VentanaJugador ventanaJugador) {
        super(ANCHO,ALTO,new ImageIcon(imagePath).getImage().getScaledInstance(ANCHO, ALTO,  java.awt.Image.SCALE_SMOOTH));
        this.edificio=edificioEnConstruccion;
        this.ventanaJugador=ventanaJugador;
    }
}

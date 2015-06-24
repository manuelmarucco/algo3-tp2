package vista.edificios.terran;

import construcciones.terran.Barraca;
import interfaces.ColocableEnMapa;
import vista.auxiliares.ImagePanel;
import vista.ventanaJugadores.VentanaJugador;

import javax.swing.*;

public class VistaBarraca extends ImagePanel {

    private static final int ANCHO = 1;
    private static final int ALTO = 2;
    private final Barraca edificio;
    private static String pathImagen="images/construcciones/terrran/barraca.png";
    private final VentanaJugador ventanaJugador;

    public VistaBarraca(ColocableEnMapa barraca,VentanaJugador ventanaJugador) {
        super(ANCHO,ALTO,new ImageIcon(pathImagen).getImage());
        super.setBackground(new ImageIcon("src/vista/paisaje/imagenes/pasto.png").getImage());
        this.edificio=(Barraca) barraca;
        this.ventanaJugador=ventanaJugador;
    }
}

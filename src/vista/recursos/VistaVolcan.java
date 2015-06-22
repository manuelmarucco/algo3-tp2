package vista.recursos;

import recursos.Volcan;
import vista.Actions.MouseActionObtenerInfoRecurso;
import vista.auxiliares.ImagePanel;
import vista.ventanaJugadores.VentanaJugador;

import javax.swing.*;

public class VistaVolcan extends ImagePanel  {

    private static final int ANCHO = 10;
    private static final int ALTO = 10;
    private final Volcan recurso;
    private static String pathImagen="/imagenes/volcan.png";
    private final VentanaJugador ventanaJugador;

    public VistaVolcan() {
        // Constructor para tests
        super(ANCHO,ALTO,new ImageIcon(pathImagen).getImage());
        this.ventanaJugador= null;
        this.setVisible(false);
        this.recurso = null;
    }

    public VistaVolcan(Volcan volcan,VentanaJugador ventanaJugador) {
        super(ANCHO,ALTO,new ImageIcon(pathImagen).getImage());
        this.recurso=volcan;
        this.ventanaJugador=ventanaJugador;
        this.addMouseListener(new MouseActionObtenerInfoRecurso(volcan,ventanaJugador));
    }
}
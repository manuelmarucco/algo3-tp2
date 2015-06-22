package vista.recursos;

import recursos.Cristal;
import vista.Actions.MouseActionObtenerInfoRecurso;
import vista.auxiliares.ImagePanel;
import vista.ventanaJugadores.VentanaJugador;

import javax.swing.*;

public class VistaCristales extends ImagePanel {

    private static final int ANCHO = 64;
    private static final int ALTO = 64;
    private final Cristal recurso;
    private static String pathImagen="src/vista/recursos/imagenes/cristal.png";
    private final VentanaJugador ventanaJugador;

    public VistaCristales() {
        // Constructor para tests
        super(ANCHO,ALTO,new ImageIcon(pathImagen).getImage());
        this.ventanaJugador= null;
        this.recurso = new Cristal();
    }

    public VistaCristales(Cristal cristal,VentanaJugador ventanaJugador) {
        super(ANCHO,ALTO,new ImageIcon(pathImagen).getImage());
        this.recurso=cristal;
        this.ventanaJugador=ventanaJugador;
        this.addMouseListener(new MouseActionObtenerInfoRecurso(cristal,ventanaJugador));
    }
}

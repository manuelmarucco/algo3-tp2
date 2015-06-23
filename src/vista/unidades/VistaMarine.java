package vista.unidades;

import unidades.terrran.Marine;
import vista.auxiliares.ImagePanel;
import vista.ventanaJugadores.VentanaJugador;

import javax.swing.*;

public class VistaMarine extends ImagePanel{

    private static final int ANCHO = 64;
    private static final int ALTO = 64;
    private final Marine unidad;
    private static String pathImagen="images/unidades/terrran/marine.png";
    private final Object ventanaJugador;

    public VistaMarine() {
        // Constructor para tests
        super(ANCHO,ALTO,new ImageIcon(pathImagen).getImage().getScaledInstance(ANCHO, ALTO,  java.awt.Image.SCALE_SMOOTH));
        super.setBackground(new ImageIcon("src/vista/paisaje/imagenes/pasto.png").getImage());
        this.ventanaJugador= null;
        this.unidad = new Marine();
    }

    public VistaMarine(Marine marine,VentanaJugador ventanaJugador) {
        super(ANCHO,ALTO,new ImageIcon(pathImagen).getImage());
        this.unidad=marine;
        this.ventanaJugador=ventanaJugador;
        //this.addMouseListener(new MouseActionObtenerInfoMarine(marine,ventanaJugador));
    }
}

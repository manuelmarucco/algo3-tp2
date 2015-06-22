package vista.unidades;

import unidades.terrran.NaveCiencia;
import vista.auxiliares.ImagePanel;

import javax.swing.*;

public class VistaNaveCiencia extends ImagePanel{

    private static final int ANCHO = 64;
    private static final int ALTO = 64;
    private final NaveCiencia unidad;
    private static String imagePath="images/unidades/terrran/naveCiencia.png";

    public VistaNaveCiencia() {
        super(ANCHO,ALTO,new ImageIcon(imagePath).getImage().getScaledInstance(ANCHO, ALTO,  java.awt.Image.SCALE_SMOOTH));
        this.unidad=null;
    }

    public VistaNaveCiencia(NaveCiencia naveCiencia/*TODO aca se pasa el panel del juego*/) {
        super(ANCHO,ALTO,new ImageIcon().getImage());
        this.unidad=naveCiencia;
    }
}

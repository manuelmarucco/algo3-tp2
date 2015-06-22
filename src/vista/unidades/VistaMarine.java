package vista.unidades;

import unidades.terrran.Marine;
import vista.auxiliares.ImagePanel;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class VistaMarine extends ImagePanel implements MouseListener {

    private static final int ANCHO = 64;
    private static final int ALTO = 64;
    private final Marine unidad;
    private static String pathImagen="images/unidades/terrran/marine64.png";

    public VistaMarine() {
        super(ANCHO,ALTO,new ImageIcon(pathImagen).getImage());
        this.unidad=null;
    }

    public VistaMarine(Marine marine/*TODO aca se pasa el panel del juego*/) {
        super(ANCHO,ALTO,new ImageIcon(pathImagen).getImage());
        this.unidad=marine;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getButton()!=MouseEvent.BUTTON1) return;
        /*Aca va la accion de
          - setear los botones
            por ejemplo pantallaJuego.getPanelDeInformacion().SetVida(unidad.getVida());
          - setear las propiedades
         */
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}

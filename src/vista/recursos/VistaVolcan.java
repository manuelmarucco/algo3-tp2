package vista.recursos;

import recursos.Volcan;
import vista.auxiliares.ImagePanel;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class VistaVolcan extends ImagePanel implements MouseListener {

    private static final int ANCHO = 10;
    private static final int ALTO = 10;
    private final Volcan recurso;
    private static String pathImagen="/imagenes/volcan.png";

    public VistaVolcan(Volcan volcan/*TODO aca se pasa el panel del juego*/) {
        super(ANCHO,ALTO,new ImageIcon(pathImagen).getImage());
        this.recurso=volcan;
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
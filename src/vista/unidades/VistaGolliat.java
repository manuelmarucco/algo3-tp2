package vista.unidades;

import unidades.terrran.Golliat;
import vista.auxiliares.ImagePanel;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class VistaGolliat extends ImagePanel implements MouseListener {

    private static final int ANCHO = 1;
    private static final int ALTO = 2;
    private final Golliat unidad;

    public VistaGolliat(Golliat golliat/*TODO aca se pasa el panel del juego*/) {
        super(ANCHO,ALTO,new ImageIcon().getImage());
        this.unidad=golliat;
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
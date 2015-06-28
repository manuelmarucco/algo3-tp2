package vista.auxiliares.jugador.botones;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseListener;

public class BotonConInformacionDesplegable extends JButton implements MouseListener {

    CuadroInformacionRecursos cuadroInformacionRecursos;


    public BotonConInformacionDesplegable(String nombre, String cristalNecesario, String gasNecesario){

        this.setText(nombre);
        addMouseListener(this);

        this.cuadroInformacionRecursos = new CuadroInformacionRecursos(cristalNecesario, gasNecesario);

    }

    public BotonConInformacionDesplegable(String nombre,String cristalNecesario, String gasNecesario, String siministroNecesario){

        this.setText(nombre);
        addMouseListener(this);

        this.cuadroInformacionRecursos = new CuadroInformacionRecursos(cristalNecesario, gasNecesario, siministroNecesario);

    }

    @Override
    public void mouseClicked(java.awt.event.MouseEvent e) {

    }

    @Override
    public void mousePressed(java.awt.event.MouseEvent e) {
    }

    @Override
    public void mouseReleased(java.awt.event.MouseEvent e) {

    }

    @Override
    public void mouseEntered(java.awt.event.MouseEvent e) {

        this.cuadroInformacionRecursos.pack();
        Point posicionCursor = MouseInfo.getPointerInfo().getLocation();
        this.cuadroInformacionRecursos.setBounds((int) posicionCursor.getX() + 10, (int) posicionCursor.getY() + 10, 150, 25);

        this.cuadroInformacionRecursos.setVisible(true);

    }

    @Override
    public void mouseExited(java.awt.event.MouseEvent e) {

        this.cuadroInformacionRecursos.setVisible(false);
        this.cuadroInformacionRecursos.dispose();

    }
}

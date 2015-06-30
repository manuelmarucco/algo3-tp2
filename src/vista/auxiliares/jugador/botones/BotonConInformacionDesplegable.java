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

    public BotonConInformacionDesplegable(String nombre,String cristalNecesario, String gasNecesario, String suministroNecesario){

        this.setText(nombre);
        addMouseListener(this);

        this.cuadroInformacionRecursos = new CuadroInformacionRecursos(cristalNecesario, gasNecesario, suministroNecesario);

    }

    public BotonConInformacionDesplegable(String nombre, String energiaNecesaria){

        this.setText(nombre);
        this.setSize(new Dimension(200,50));

        addMouseListener(this);

        this.cuadroInformacionRecursos = new CuadroInformacionRecursos(energiaNecesaria);

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
        this.cuadroInformacionRecursos.setBounds((int) posicionCursor.getX() + 10, (int) posicionCursor.getY() + 10, 200, 25);

        this.cuadroInformacionRecursos.setVisible(true);

    }

    @Override
    public void mouseExited(java.awt.event.MouseEvent e) {

        this.cuadroInformacionRecursos.setVisible(false);
        this.cuadroInformacionRecursos.dispose();

    }

    public void actualizarCaracteristicas(String nombre,String cristalNecesario, String gasNecesario, String suministroNecesario){

        this.removeAll();
        this.setText(nombre);
        addMouseListener(this);

        this.cuadroInformacionRecursos = new CuadroInformacionRecursos(cristalNecesario, gasNecesario, suministroNecesario);


    }

    public void actualizarCaracteristicas(String nombre, String energiaNecesaria){

        this.removeAll();
        this.setText(nombre);
        addMouseListener(this);

        this.cuadroInformacionRecursos = new CuadroInformacionRecursos(energiaNecesaria);


    }

    public void eliminarInformacionDesplegable(){

        this.cuadroInformacionRecursos = null;

    }



}

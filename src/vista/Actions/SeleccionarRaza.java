package vista.Actions;

import vista.CrearJugador;
import vista.auxiliares.ImagePanel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SeleccionarRaza implements java.awt.event.ActionListener {

    private final CrearJugador form;
    private final ImagePanel retrato;

    public SeleccionarRaza(CrearJugador crearJugador, ImagePanel imagen){
        this.form=crearJugador;
        this.retrato=imagen;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        JComboBox c = (JComboBox) e.getSource();
        switch ((String)c.getSelectedItem()){
            case "Protoss":
                form.getAceptarButton().addActionListener(new CrearProtoss());
                retrato.setImage(new ImageIcon("src/vista/resourses/retratoProtoss.jpg").getImage());
                retrato.repaint();
                break;
            case "Terran":

                form.getAceptarButton().addActionListener(new CrearTerran());
                retrato.setImage(new ImageIcon("src/vista/resourses/retratoTerran.jpg").getImage());
                retrato.repaint();
        }
    }

    private class CrearProtoss implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            //TODO:crear protoss
        }
    }

    private class CrearTerran implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            //TODO:crear terran
        }
    }
}

package vista.Actions;

import jugabilidad.Juego;
import vista.CrearJugador;
import vista.auxiliares.ImagePanel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SeleccionarRaza implements java.awt.event.ActionListener {

    private final CrearJugador form;
    private final ImagePanel retrato;
    private final Juego juego;

    public SeleccionarRaza(CrearJugador crearJugador, ImagePanel imagen){
        this.form=crearJugador;
        this.retrato=imagen;
        this.juego = null;
    }

    public SeleccionarRaza(CrearJugador crearJugador, ImagePanel retrato, Juego j) {
        this.form=crearJugador;
        this.retrato=retrato;
        this.juego=j;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JComboBox c = (JComboBox) e.getSource();
        switch ((String)c.getSelectedItem()){
            case "Protoss":
                form.getAceptarButton().addActionListener(new CrearProtoss(juego));
                retrato.setImage(new ImageIcon("src/vista/resourses/retratoProtoss.jpg").getImage());
                retrato.repaint();
                break;
            case "Terran":

                form.getAceptarButton().addActionListener(new CrearTerran(juego));
                retrato.setImage(new ImageIcon("src/vista/resourses/retratoTerran.jpg").getImage());
                retrato.repaint();
        }
    }

    private class CrearProtoss implements ActionListener {
        private final Juego juego;

        public CrearProtoss(Juego juego) {
            this.juego=juego;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            juego.crearJugadorProtoss(null,null,null);
        }
    }

    private class CrearTerran implements ActionListener {
        private final Juego juego;

        public CrearTerran(Juego juego) {
            this.juego=juego;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            juego.crearJugadorTerran(null, null, null);
        }
    }
}

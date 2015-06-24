package vista.Actions;

import jugabilidad.utilidadesMapa.Coordenadas;
import vista.CrearJugador;
import vista.VentanaJuego;
import vista.auxiliares.ImagePanel;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class SeleccionarRaza implements java.awt.event.ActionListener {

    private final CrearJugador form;
    private final ImagePanel retrato;
    private final Coordenadas coordenadas;
    private VentanaJuego ventanaJuego;
    private String nombreUsado;
    private String colorUsado;

    public SeleccionarRaza(CrearJugador crearJugador, ImagePanel retrato, VentanaJuego ventanaJuego, String colorUsado, String nombreUsado, Coordenadas coordenadas) {
        this.form=crearJugador;
        this.retrato=retrato;
        this.ventanaJuego=ventanaJuego;
        this.nombreUsado=nombreUsado;
        this.colorUsado=colorUsado;
        this.coordenadas=coordenadas;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JComboBox c = (JComboBox) e.getSource();
        switch ((String)c.getSelectedItem()){
            case "Protoss":
                form.getAceptarButton().removeActionListener(form.getAceptarButton().getActionListeners()[0]);
                form.getAceptarButton().addActionListener(new CrearProtoss(ventanaJuego,form,nombreUsado,colorUsado,coordenadas));
                retrato.setImage(new ImageIcon("src/vista/resourses/retratoProtoss.jpg").getImage());
                retrato.repaint();
                break;
            case "Terran":
                form.getAceptarButton().removeActionListener(form.getAceptarButton().getActionListeners()[0]);
                form.getAceptarButton().addActionListener(new CrearTerran(ventanaJuego,form,nombreUsado,colorUsado,coordenadas));
                retrato.setImage(new ImageIcon("src/vista/resourses/retratoTerran.jpg").getImage());
                retrato.repaint();
        }
    }

}

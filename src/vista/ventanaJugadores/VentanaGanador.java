package vista.ventanaJugadores;


import vista.VentanaJuego;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.font.TextAttribute;
import java.util.Map;

public class VentanaGanador extends JFrame {

    JPanel contenedor;

    public VentanaGanador(VentanaJuego ventanaJuego) {
        this.init();
        this.mostrarGanador(ventanaJuego.getJuego().getJugadorGanador().getNombre());
        this.mostrarVentanaGanador();
        ventanaJuego.cerrarVentanas();
    }

    private void init() {
        //this.getContentPane().setBackground(new Color(0, 50, 100));
        this.contenedor = new JPanel();
        this.contenedor.setOpaque(false);
        this.contenedor.setLayout(new BoxLayout(this.contenedor,BoxLayout.Y_AXIS));
    }

    private void mostrarVentanaGanador() {
        this.setPreferredSize(new Dimension(200, 400));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }


    private void mostrarGanador(String nombreGanador) {
        JLabel ganador = new JLabel();
        this.setearFuenteDeJLabel(ganador, false, Font.BOLD, 30);
        ganador.setText(nombreGanador);
        this.contenedor.add(ganador);

        JButton botonTerminar = new JButton();
        botonTerminar.addActionListener(new ActionTerminarJuego(this));
        this.contenedor.add(botonTerminar);
    }


    protected void setearFuenteDeJLabel(JLabel label,boolean underline,int fontType,int fontSize){

        Font font = new Font("StarcraftNormal", fontType, fontSize);
        if(underline){
            Map attributes = font.getAttributes();
            attributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
            label.setFont(font.deriveFont(attributes));
        }
        label.setForeground(new Color(200, 200, 20));

    }
}
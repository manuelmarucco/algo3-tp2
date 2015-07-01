package vista.ventanaJugadores;


import vista.VentanaJuego;
import vista.auxiliares.ImagePanel;

import javax.swing.*;
import java.awt.*;
import java.awt.font.TextAttribute;
import java.util.Map;

public class VentanaGanador extends JFrame {


    JPanel contenedor;
    private ImagePanel imageBackground;

    public VentanaGanador(VentanaJuego ventanaJuego) {
        this.init();
        this.mostrarGanador(ventanaJuego.getJuego().getJugadorGanador().getNombre());
        this.mostrarVentanaGanador();
        ventanaJuego.cerrarVentanas();
    }

    private void init() {
        //this.getContentPane().setBackground(new Color(0, 50, 100));
        this.contenedor.setOpaque(false);
        this.contenedor.setLayout(new BoxLayout(this.contenedor,BoxLayout.Y_AXIS));
        this.contenedor.add(this.imageBackground);

        this.add(contenedor);
    }

    private void mostrarVentanaGanador() {
        this.setPreferredSize(new Dimension(657,364));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setVisible(true);
    }


    private void mostrarGanador(String nombreGanador) {
        JLabel ganador = new JLabel();
        this.setearFuenteDeJLabel(ganador, false, Font.BOLD, 30);
        ganador.setText(nombreGanador);
        this.contenedor.add(ganador);

        JButton botonTerminar = new JButton();
        botonTerminar.setText("Salir");
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

    private void createUIComponents() {
        this.imageBackground = new ImagePanel("images/menu/panelGanador.jpg",657,364);
    }
}

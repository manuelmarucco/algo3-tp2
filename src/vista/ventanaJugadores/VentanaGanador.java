package vista.ventanaJugadores;


import vista.Actions.accionesJuego.ActionTerminarJuego;
import vista.VentanaJuego;
import vista.auxiliares.ImagePanel;

import javax.swing.*;
import java.awt.*;
import java.awt.font.TextAttribute;
import java.util.Map;

public class VentanaGanador extends JFrame {


    private JLayeredPane contenedor;

    public VentanaGanador(VentanaJuego ventanaJuego,String nombreGanador) {

        this.init(nombreGanador);
        ventanaJuego.cerrarVentanas();

    }

    private void init(String nombreGanador) {

        this.contenedor = new JLayeredPane();

        this.armarComponentes(nombreGanador);
        this.configurarVentana();

        this.add(contenedor);

    }


    private void armarComponentes(String nombreGanador) {

        ImagePanel imageBackground = new ImagePanel("images/menu/panelGanador.jpg", 657, 364);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel,BoxLayout.Y_AXIS));
        panel.setOpaque(false);

        JLabel nombre = new JLabel();
        this.setearFuenteDeJLabel(nombre, false, Font.BOLD, 45);
        nombre.setText(nombreGanador);
        panel.add(nombre);

        JButton botonSalir = new JButton();
        botonSalir.setText("Salir");
        botonSalir.addActionListener(new ActionTerminarJuego(this));
        panel.add(botonSalir);

        //this.contenedor.add(imageBackground); // Esta se agrega
        this.contenedor.add(panel); // No se agrega

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

    private void configurarVentana() {

        //this.setUndecorated(true);
        //this.getRootPane().setWindowDecorationStyle(JRootPane.NONE);

        this.setPreferredSize(new Dimension(657,364));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setVisible(true);

    }

}

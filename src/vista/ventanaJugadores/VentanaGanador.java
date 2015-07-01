package vista.ventanaJugadores;

import vista.Actions.accionesJuego.ActionTerminarJuego;
import vista.VentanaJuego;
import vista.auxiliares.ImagePanel;

import javax.swing.*;
import java.awt.*;
import java.awt.font.TextAttribute;
import java.util.Map;

public class VentanaGanador extends JFrame {

    private JPanel contenedor;

    public VentanaGanador(VentanaJuego ventanaJuego,String nombreGanador) {

        this.init(nombreGanador);
        ventanaJuego.cerrarVentanas();

    }

    private void init(String nombreGanador) {

        this.contenedor = new JPanel();

        this.armarComponentes(nombreGanador);
        this.configurarVentana();

        this.add(contenedor);

    }


    private void armarComponentes(String nombreGanador) {

        JPanel panel =  new JPanel();
        panel.setLayout(new GridLayout(4,1,0,30));
        panel.setMaximumSize(new Dimension(657, 364));
        panel.setAlignmentY(50);
        panel.setOpaque(false);

        JLabel nombre = new JLabel();
        this.setearFuenteDeJLabel(nombre, Font.BOLD, 20);
        nombre.setText("       Felicidades: " + nombreGanador);
        panel.add(nombre);

        JLabel infoGanador = new JLabel();
        this.setearFuenteDeJLabel(infoGanador, Font.BOLD, 20);
        infoGanador.setText("Por ser el ganador de la partida.");
        panel.add(infoGanador);

        JLabel agradecimiento = new JLabel();
        this.setearFuenteDeJLabel(agradecimiento, Font.BOLD, 20);
        agradecimiento.setText("    Gracias por jugar Algocraft");
        panel.add(agradecimiento);

        JButton botonSalir = new JButton();
        botonSalir.setIcon(new ImageIcon("images/menu/salirBoton.png"));
        botonSalir.setBackground(new Color(0,0,150,80));
        botonSalir.setMargin(new Insets(0, 0, 0, 0));
        botonSalir.addActionListener(new ActionTerminarJuego(this));
        panel.add(botonSalir);

        this.contenedor.add(panel);

    }


    protected void setearFuenteDeJLabel(JLabel label,int fontType,int fontSize){

        Font font = new Font("images/StarcraftNormal.ttf", fontType, fontSize);

        Map attributes = font.getAttributes();
        label.setFont(font.deriveFont(attributes));

        label.setForeground(new Color(200, 200, 20));

    }

    private void configurarVentana() {

        this.setUndecorated(true);
        this.getRootPane().setWindowDecorationStyle(JRootPane.NONE);
        this.setAlwaysOnTop(true);

        this.setPreferredSize(new Dimension(657, 364));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setVisible(true);

    }

}

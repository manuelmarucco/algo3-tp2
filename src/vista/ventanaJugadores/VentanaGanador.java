package vista.ventanaJugadores;

import control.Actions.accionesJuego.ActionTerminarJuego;
import vista.VentanaJuego;

import javax.swing.*;
import java.awt.*;
import java.util.Map;

public class VentanaGanador extends JFrame {

    private JLayeredPane contenedor;
    private JLabel background;

    public VentanaGanador(VentanaJuego ventanaJuego,String nombreGanador) {

        this.init(nombreGanador);
        ventanaJuego.cerrarVentanas();

    }

    private void init(String nombreGanador) {

        this.configurarFondo();
        this.configurarContenedor();
        this.armarComponentes(nombreGanador);
        this.configurarVentana();

        this.setLocationRelativeTo(null);
        this.add(contenedor);

    }

    private void configurarFondo(){

        ImageIcon imageBackground = new ImageIcon("images/menu/panelAzul.png");
        this.background = new JLabel(imageBackground);
        this.background.setSize(new Dimension(657, 364));

    }

    private void configurarContenedor(){

        this.contenedor = new JLayeredPane();
        this.contenedor.setPreferredSize(new Dimension(background.getIcon().getIconWidth(),background.getIcon().getIconHeight()));
        this.contenedor.add(this.background, new Integer(50),0);

        this.add(contenedor);

    }


    private void armarComponentes(String nombreGanador) {

        JPanel panel =  new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setSize(new Dimension(background.getIcon().getIconWidth(), background.getIcon().getIconHeight()));
        panel.setOpaque(false);

        panel.add(Box.createRigidArea(new Dimension(0,60))); // SEPARADOR

        JLabel nombre = new JLabel();
        this.setearFuenteDeJLabel(nombre, Font.BOLD, 20);
        nombre.setText("Felicidades: " + nombreGanador);
        nombre.setAlignmentX(CENTER_ALIGNMENT);
        panel.add(nombre);

        panel.add(Box.createRigidArea(new Dimension(0,30))); // SEPARADOR

        JLabel infoGanador = new JLabel();
        this.setearFuenteDeJLabel(infoGanador, Font.BOLD, 20);
        infoGanador.setText("Por ser el ganador de la partida.");
        infoGanador.setAlignmentX(CENTER_ALIGNMENT);
        panel.add(infoGanador);

        panel.add(Box.createRigidArea(new Dimension(0,30))); // SEPARADOR

        JLabel agradecimiento = new JLabel();
        this.setearFuenteDeJLabel(agradecimiento, Font.BOLD, 20);
        agradecimiento.setText("Gracias por jugar Algocraft");
        agradecimiento.setAlignmentX(CENTER_ALIGNMENT);
        panel.add(agradecimiento);

        panel.add(Box.createRigidArea(new Dimension(0,30))); // SEPARADOR

        JButton botonSalir = new JButton();
        botonSalir.setIcon(new ImageIcon("images/menu/botones/salirBoton.png"));
        botonSalir.setBackground(new Color(0,0,150,80));
        botonSalir.setMargin(new Insets(0, 0, 0, 0));
        botonSalir.addActionListener(new ActionTerminarJuego(this));
        botonSalir.setAlignmentX(CENTER_ALIGNMENT);
        panel.add(botonSalir);

        this.contenedor.add(panel, new Integer(100),0);

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

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setVisible(true);

    }

}

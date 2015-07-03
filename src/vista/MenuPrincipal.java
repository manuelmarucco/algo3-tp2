package vista;

import modelo.jugabilidad.Juego;
import control.Actions.accionesMenu.AccionJugar;
import control.Actions.accionesMenu.AccionSalir;
import javax.swing.*;
import java.awt.*;

public class MenuPrincipal extends JFrame {

    private JLayeredPane contenedor;
    private JLabel background;
    private VentanaJuego ventanaJuego;

    public MenuPrincipal(){
        this.init();
    }

    private void init() {
        System.setProperty("sun.java2d.opengl","True");
        //inicializacion del juego en general
        this.ventanaJuego = new VentanaJuego(new Juego(2));

        this.configurarFondo();
        this.configurarContenedor();
        this.configurarBotones();

    }

    private void configurarContenedor(){

        this.contenedor = new JLayeredPane();
        this.contenedor.setPreferredSize(new Dimension(background.getIcon().getIconWidth(),background.getIcon().getIconHeight()));
        this.contenedor.add(this.background, new Integer(50),0);

        this.add(contenedor);

    }

    private void configurarFondo(){

        ImageIcon imageBackground = new ImageIcon("images/menu/fondos/background.jpg");
        this.background = new JLabel(imageBackground);
        this.background.setBounds(0, 0, imageBackground.getIconWidth(), imageBackground.getIconHeight());

    }

    private void configurarBotones(){

        JPanel botonera = new JPanel(new GridLayout(2,1,0,5));
        botonera.setOpaque(false);
        int posicionX = 540;
        int posicionY = 250;
        botonera.setBounds( posicionX, posicionY,  318, 110);

        // Configuracion del boton "Jugar"
        JButton jugarBoton = new JButton();
        jugarBoton.setIcon( new ImageIcon("images/menu/botones/botonJugar.png"));
        jugarBoton.setMargin(new Insets(0, 0, 0, 0));
        jugarBoton.setOpaque(false);
        jugarBoton.addActionListener(new AccionJugar(this.ventanaJuego));

        //configuracion del boton "Salir"
        JButton salirBoton= new JButton();
        salirBoton.setIcon(new ImageIcon("images/menu/botones/salirBoton.png"));
        salirBoton.setBackground(new Color(0,0,150,80));
        salirBoton.setMargin(new Insets(0, 0, 0, 0));
        salirBoton.addActionListener(new AccionSalir(this));

        botonera.add( jugarBoton );
        botonera.add( salirBoton );

        this.contenedor.add(botonera, new Integer(100),0);

    }

}

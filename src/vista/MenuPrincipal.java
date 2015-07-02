package vista;

import modelo.jugabilidad.Juego;
import control.Actions.accionesMenu.AccionJugar;
import control.Actions.accionesMenu.AccionSalir;
import vista.auxiliares.ImagePanel;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class MenuPrincipal extends JFrame {

    private JPanel background;
    private ImagePanel imageBackground;
    private JButton jugarBoton;
    private JButton salirBoton;

    //private VentanaJuego ventanaJuego;

    public MenuPrincipal(){
        this.init();
    }

    private void init() {
        System.setProperty("sun.java2d.opengl","True");
        //inicializacion del juego en general
        VentanaJuego ventanaJuego = new VentanaJuego(new Juego(2));

        //configuracion del boton "Jugar"
        jugarBoton.setIcon( new ImageIcon("images/menu/botones/botonJugar.png"));
        jugarBoton.setMargin(new Insets(0, 0, 0, 0));
        jugarBoton.setOpaque(false);
        jugarBoton.addActionListener(new AccionJugar(ventanaJuego));


        //configuracion del boton "Salir"
        salirBoton.setIcon(new ImageIcon("images/menu/botones/salirBoton.png"));
        salirBoton.setBackground(new Color(0,0,150,80));
        salirBoton.setMargin(new Insets(0, 0, 0, 0));
        salirBoton.addActionListener(new AccionSalir(this));

        //configuracion del fondo de pantalla
        this.add(background);

    }

    public static void main(String[] args){
        MenuPrincipal menuPrincipal = new MenuPrincipal();
        menuPrincipal.pack();
        menuPrincipal.setExtendedState(JFrame.MAXIMIZED_BOTH);
        menuPrincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        menuPrincipal.setVisible(true);
    }

    private void createUIComponents() throws IOException, FontFormatException {
        imageBackground = new ImagePanel("images/menu/fondos/background.jpg",1280,720);
    }

}

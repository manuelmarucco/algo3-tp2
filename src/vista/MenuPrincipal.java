package vista;

import Actions.AccionJugar;
import jugabilidad.Juego;
import vista.auxiliares.ImagePanel;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class MenuPrincipal extends JFrame {

    private JPanel background;
    private ImagePanel imageBackground;
    private JButton jugarBoton;

    public MenuPrincipal(){
        this.init();
    }

    private void init() {
        //inicializacion del juego en general
        Juego juego = new Juego();
        //configuracion del boton "Jugar"
        jugarBoton.setIcon(new ImageIcon("images/menu/botonJugar.png"));
        jugarBoton.setMargin(new Insets(0, 0, 0, 0));
        jugarBoton.setBorder(null);
        //jugarBoton.setOpaque(false);
        jugarBoton.addActionListener(new AccionJugar(juego));

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
        imageBackground = new ImagePanel("images/menu/background.jpg",1280,720);
    }


}

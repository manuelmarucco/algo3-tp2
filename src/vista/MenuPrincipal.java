package vista;

import vista.auxiliares.ImagePanel;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class MenuPrincipal extends JFrame {

    private JPanel background;
    private ImagePanel imageBackground;
    private JButton button1;
    private JButton button2;
    private JButton crearJugadorBoton;

    public MenuPrincipal(){
        this.init();
    }

    private void init() {
        //configuracion del boton de Crear Jugador
        crearJugadorBoton.setIcon(new ImageIcon("images/boton.png"));
        crearJugadorBoton.setMargin(new Insets(0, 0, 0, 0));
        crearJugadorBoton.setBorder(null);
        crearJugadorBoton.setVerticalTextPosition(SwingConstants.BOTTOM);
        crearJugadorBoton.setHorizontalTextPosition(SwingConstants.CENTER);

        //configuracion del fondo de pantalla
        this.add(background);
    }

    public static void main(String[] args){
        MenuPrincipal menuPrincipal = new MenuPrincipal();
        menuPrincipal.pack();
        menuPrincipal.setVisible(true);
    }
    private void createUIComponents() throws IOException, FontFormatException {
        imageBackground = new ImagePanel("images/menu/background.jpg",1280,720);
    }

}

package vista;

import vista.auxiliares.ImagePanel;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class MenuPrincipal extends JFrame {

    private JPanel background;
    private ImagePanel imageBackground;
    private JButton juegarButton;

    public MenuPrincipal(){
        this.init();
    }

    private void init() {
        juegarButton.setIcon(new ImageIcon("images/menu/botonJugar.png"));
        juegarButton.setMargin(new Insets(0, 0, 0, 0));
        juegarButton.setBorder(null);

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

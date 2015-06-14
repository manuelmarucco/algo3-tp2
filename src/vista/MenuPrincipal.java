package vista;

import vista.auxiliares.ImagePanel;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class MenuPrincipal extends JFrame {

    private JPanel background;
    private ImagePanel imageBackground;

    public MenuPrincipal(){
        this.init();
    }

    private void init() {
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

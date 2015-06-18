package vista.auxiliares.jugador;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class DisplayNotificaciones extends JPanel {

    private BufferedImage background;

    public DisplayNotificaciones(){
        this.init();
    }

    private void init() {
        this.setBackground(Color.BLACK);
        this.setSize(new Dimension(200,100));
    }

    public void mostrarNotificacion(){

    }
}

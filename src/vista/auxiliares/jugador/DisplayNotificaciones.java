package vista.auxiliares.jugador;

import interfaces.Mostrable;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

//Como es un JLabel debe estar contenido en un JPanel.

public class DisplayNotificaciones extends JLabel {

    private BufferedImage background;

    public DisplayNotificaciones(){
        this.init();
    }

    private void init() {
        this.setBackground(new Color(0,0,0));
        this.setOpaque(true);
        this.inicializarTipoDeLetra();
        this.setPreferredSize(new Dimension(100,100));
    }

    public void mostrarNotificacion(Mostrable e){

        this.setText(e.mostrarMensaje());
    }

    public void inicializarTipoDeLetra(){
        Font font = new Font("Verdana", Font.BOLD, 12);
        this.setFont(font);
        this.setForeground(Color.red);
    }


/*
    private static BufferedImage cambiarTamanio(BufferedImage img, int newW, int newH) {
        Image tmp = img.getScaledInstance(newW, newH, Image.SCALE_SMOOTH);
        BufferedImage dimg = new BufferedImage(newW, newH, BufferedImage.TYPE_INT_ARGB);

        Graphics2D g2d = dimg.createGraphics();
        g2d.drawImage(tmp, 0, 0, null);
        g2d.dispose();

        return dimg;
    }
    */
}

package vista.auxiliares.jugador;

import interfaces.Mostrable;

import javax.swing.*;
import java.awt.*;

//Como es un JLabel debe estar contenido en un JPanel.

public class DisplayNotificaciones extends JPanel {

    private JLayeredPane layeredPane;
    private JTextArea notificacion;
    private JLabel background;

    public DisplayNotificaciones(){
        this.initBackground();
        this.initNotificacion();
        this.initLayeredPane();

    }

    private void initLayeredPane() {
        this.layeredPane = new JLayeredPane();

        this.layeredPane.setPreferredSize(new Dimension(background.getIcon().getIconWidth(),background.getIcon().getIconHeight()));
        this.layeredPane.add(this.background, new Integer(50));
        this.layeredPane.add(this.notificacion, new Integer(100));

        this.add(layeredPane);
    }


    private void initBackground() {
        ImageIcon imageBackground = new ImageIcon("images/menu/panelNotificaciones.png");
        this.background = new JLabel(imageBackground);
        this.background.setBounds(0, 0, imageBackground.getIconWidth(), imageBackground.getIconHeight());

    }

    private void initNotificacion() {
        this.notificacion = new JTextArea();
        this.notificacion.setLineWrap(true);
        this.notificacion.setOpaque(false);
        this.inicializarTipoDeLetra();
        this.notificacion.setBounds( 20, 50,  background.getIcon().getIconWidth()-30, background.getIcon().getIconHeight()-50);
    }


    private void inicializarTipoDeLetra(){
        Font font = new Font("Verdana", Font.BOLD, 12);
        notificacion.setFont(font);
        notificacion.setForeground(Color.red);
    }


    public void mostrarNotificacion(Mostrable e){

        notificacion.setText(e.mostrarMensaje());
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

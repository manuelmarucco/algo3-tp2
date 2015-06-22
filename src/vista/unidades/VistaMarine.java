package vista.unidades;

import unidades.terrran.Marine;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.IOException;

public class VistaMarine extends JPanel implements MouseListener {

    private static final int ANCHO = 64;
    private static final int ALTO = 64;
    private final Marine unidad;
    private static String pathImagen="images/unidades/terrran/marine.png";
    private BufferedImage image;

    public VistaMarine() {
        try {
            this.image = ImageIO.read(new FileInputStream(pathImagen));
        } catch (IOException e) {
            e.printStackTrace();
        }

        this.setOpaque(false);
        this.image = this.cambiarTamanio(this.image,ANCHO,ALTO);
        this.unidad=null;
    }

    public VistaMarine(Marine marine/*TODO aca se pasa el panel del juego*/) {
        //this();
        this.unidad=marine;

    }

    private static BufferedImage cambiarTamanio(BufferedImage img, int newW, int newH) {
        Image tmp = img.getScaledInstance(newW, newH, Image.SCALE_SMOOTH);
        BufferedImage dimg = new BufferedImage(newW, newH, BufferedImage.TYPE_INT_ARGB);

        Graphics2D g2d = dimg.createGraphics();
        g2d.drawImage(tmp, 0, 0, null);
        g2d.dispose();

        return dimg;
    }

    @Override
    protected void paintComponent(Graphics g) {

        super.paintComponent(g);
        g.drawImage(image, 0, 0, null);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getButton()!=MouseEvent.BUTTON1) return;
        /*Aca va la accion de
          - setear los botones
            por ejemplo pantallaJuego.getPanelDeInformacion().SetVida(unidad.getVida());
          - setear las propiedades
         */
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}

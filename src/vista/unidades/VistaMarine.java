package vista.unidades;

import unidades.terrran.Marine;
import vista.auxiliares.ImagePanel;
import vista.ventanaJugadores.VentanaJugador;

import javax.swing.*;
import java.awt.image.BufferedImage;

public class VistaMarine extends ImagePanel{

    private static final int ANCHO = 64;
    private static final int ALTO = 64;
    private final Marine unidad;
    private static String pathImagen="images/unidades/terrran/marine.png";
    private final Object ventanaJugador;
    private BufferedImage image;

    public VistaMarine() {
        // Constructor para tests
        super(ANCHO,ALTO,new ImageIcon(pathImagen).getImage().getScaledInstance(ANCHO, ALTO,  java.awt.Image.SCALE_SMOOTH));
        this.ventanaJugador= null;
        this.unidad = new Marine();
    }

    public VistaMarine(Marine marine,VentanaJugador ventanaJugador) {
        super(ANCHO,ALTO,new ImageIcon(pathImagen).getImage().getScaledInstance(ANCHO, ALTO,  java.awt.Image.SCALE_SMOOTH));
        this.unidad=marine;
        this.ventanaJugador=ventanaJugador;
        //this.addMouseListener(new MouseActionObtenerInfoMarine(marine,ventanaJugador));
    }
//    public VistaMarine() {
//        try {
//            this.image = ImageIO.read(new FileInputStream(pathImagen));
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        this.setOpaque(false);
//        this.image = this.cambiarTamanio(this.image,ANCHO,ALTO);
//        this.unidad=null;
//    }
//
//    public VistaMarine(Marine marine/*TODO aca se pasa el panel del juego*/) {
//        //this();
//        this.unidad=marine;
//
//    }
//
//    private static BufferedImage cambiarTamanio(BufferedImage img, int newW, int newH) {
//        Image tmp = img.getScaledInstance(newW, newH, Image.SCALE_SMOOTH);
//        BufferedImage dimg = new BufferedImage(newW, newH, BufferedImage.TYPE_INT_ARGB);
//
//        Graphics2D g2d = dimg.createGraphics();
//
//        g2d.drawImage(tmp, 0, 0, null);
//        g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER));
//        g2d.dispose();
//
//        return dimg;
//
//        /* //TODO este casi que funciona pero dibuja el fondo en negro
//        BufferedImage newImg = new BufferedImage(newW, newH, BufferedImage.TYPE_INT_ARGB);
//        Graphics2D g = newImg.createGraphics();
//
//        g.setComposite(AlphaComposite.SrcOver);
//        g.setBackground(new Color(0,0,0,0));
//        g.setColor(new Color(0, 0, 0, 0));
//        g.fillRect(0, 0, newW, newH);
//        g.drawImage(img,0,0,newW,newH, new Color(0, 0, 0, 0), null);
//        g.dispose();
//        return newImg;
//        */
//    }
//
//    @Override
//    protected void paintComponent(Graphics g) {
//
//        super.paintComponent(g);
//        g.drawImage(image, 0, 0, null);
//    }
//    */
}

package vista.menusDePrueba;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.IOException;

public class Background extends JLabel {
    double scale = 2; // setear de manera que el jugador vea una proporcion adecuada del mapa
    BufferedImage image = null;

    public Background(String fileDirectory) {
        try {
            image = ImageIO.read(new FileInputStream(fileDirectory));
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.setIcon(new ImageIcon(image));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        int imageWidth = image.getWidth();
        int imageHeight = image.getHeight();
        BufferedImage bi = new BufferedImage((int)(imageWidth*scale), (int)(imageHeight*scale), image.getType());
        Graphics2D g2 = bi.createGraphics();

        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        AffineTransform at = AffineTransform.getTranslateInstance(0, 0);
        at.scale(scale, scale);
        g2.drawRenderedImage(image, at);

        this.setIcon(new ImageIcon(bi));

    }

}

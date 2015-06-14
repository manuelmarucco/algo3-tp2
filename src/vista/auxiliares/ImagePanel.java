package vista.auxiliares;

import javax.swing.*;
import java.awt.*;

public class ImagePanel extends JPanel {

    private final int x;
    private final int y;
    private Image img;

    public ImagePanel(String img, int x, int y) {
        this(x, y, new ImageIcon(img).getImage());
    }

    public ImagePanel(int x, int y, Image img) {
        this.x = x;
        this.y = y;
        this.img = img;
        Dimension size = new Dimension(x, y);
        setPreferredSize(size);
        setMinimumSize(size);
        setMaximumSize(size);
        setSize(size);
        setLayout(null);
    }

    public void paintComponent(Graphics g) {
        g.drawImage(img, 0, 0, null);
    }

    public void setImage(Image img){
         this.img=img;
    }
}

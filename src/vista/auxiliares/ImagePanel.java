package vista.auxiliares;

import jugabilidad.utilidadesMapa.Coordenadas;

import javax.swing.*;
import java.awt.*;

public class ImagePanel extends JPanel {

    private final int x;
    private final int y;
    private Coordenadas posicioEnPantalla;
    private Image img;

    public void setPosicionEnPantalla(Coordenadas coordenadas){

        this.posicioEnPantalla = coordenadas;

    }

    public ImagePanel(String img, int x, int y) {
        this(x, y, new ImageIcon(img).getImage());
    }

    public ImagePanel(int x, int y, Image img) {
        this.x = x;
        this.y = y;
        this.img = img;
        this.posicioEnPantalla = new Coordenadas(0,0);
        Dimension size = new Dimension(x, y);
        setPreferredSize(size);
        setMinimumSize(size);
        setMaximumSize(size);
        setSize(size);
        setLayout(null);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(img, posicioEnPantalla.getX(), posicioEnPantalla.getY(), null);
    }

    public void setImage(Image img){
         this.img=img;
    }
}

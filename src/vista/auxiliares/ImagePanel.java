package vista.auxiliares;

import jugabilidad.utilidadesMapa.Coordenada;

import javax.swing.*;
import java.awt.*;

public class ImagePanel extends JPanel {

    private final int x;
    private final int y;
    private Coordenada posicioEnPantalla;
    private Image img;
    private Image bg;

    public void setPosicionEnPantalla(Coordenada coordenada){

        this.posicioEnPantalla = coordenada;

    }

    public ImagePanel(String img, int x, int y) {
        this(x, y, new ImageIcon(img).getImage());
    }

    public ImagePanel(int x, int y, Image img) {
        this.x = x;
        this.y = y;
        this.img = img;
        this.posicioEnPantalla = new Coordenada(0,0);
        Dimension size = new Dimension(x, y);
        setPreferredSize(size);
        setMinimumSize(size);
        setMaximumSize(size);
        setSize(size);
        setLayout(null);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        if(bg!=null)
            g.drawImage(bg, posicioEnPantalla.getX(), posicioEnPantalla.getY(), this);
        g.drawImage(img, posicioEnPantalla.getX(), posicioEnPantalla.getY(), this);

    }

    public void setImage(Image img){
         this.img=img;
    }

    public void setBackground(Image bg){
        this.bg=bg;
    }
}

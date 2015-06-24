package vista.auxiliares;

import javax.swing.*;
import java.awt.*;

public class IconoColor implements Icon {

    private static final int DEFAULT_WIDTH = 10;
    private static final int DEFAULT_HEIGHT = 10;
    private final Color color;
    private final boolean selected;
    private final int width;
    private final int height;

    public String getNombre() {
        return nombre;
    }

    private final String nombre;
    private Polygon poly;

    public IconoColor(Color color,String nombre) {
        this(color, true, DEFAULT_WIDTH, DEFAULT_HEIGHT,nombre);
    }

    public IconoColor(Color color, boolean selected,String nombre) {
        this(color, selected, DEFAULT_WIDTH, DEFAULT_HEIGHT,nombre);
    }

    public IconoColor(Color color, boolean selected, int width, int height,String nombre) {
        this.nombre=nombre;
        this.color = color;
        this.selected = selected;
        this.width = width;
        this.height = height;
        initPolygon();
    }

    private void initPolygon() {
        poly = new Polygon();
        poly.addPoint(0, 0);
        poly.addPoint(width, 0);
        poly.addPoint(width, height);
        poly.addPoint(0, height);
    }

    @Override
    public void paintIcon(Component c, Graphics g, int x, int y) {
        g.setColor(color);
        g.translate(x, y);
        if (selected) {
            g.fillPolygon(poly);
        } else {
            g.drawPolygon(poly);
        }
        g.translate(-x, -y);
        g.setColor(Color.black);
        g.drawString(nombre,x+11,y+10);
    }

    @Override
    public int getIconWidth() {
        return width;
    }

    @Override
    public int getIconHeight() {
        return height;
    }
}
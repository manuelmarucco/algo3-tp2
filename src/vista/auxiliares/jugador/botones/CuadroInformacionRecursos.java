package vista.auxiliares.jugador.botones;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.font.TextAttribute;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Map;

public class CuadroInformacionRecursos extends JFrame {

    private JPanel contenedor;
    private BufferedImage[] imagenes;

    // Para construcciones
    public CuadroInformacionRecursos(String cristalNecesario, String gasNecesario){

        this.setUndecorated(true);
        this.getRootPane().setWindowDecorationStyle(JRootPane.NONE);
        this.setLayout(new BorderLayout());
        this.setContentPane(new JLabel(new ImageIcon("images/menu/boton.png")));
        this.setLayout(new FlowLayout());

        this.contenedor = new JPanel(new GridLayout(1,3,0,1));
        this.contenedor.setOpaque(false);

        this.cargarImagenes();

        this.contenedor.add(this.armarLabelTituloCosto());
        this.contenedor.add(this.armarLabelCristaleNecesario(cristalNecesario));
        this.contenedor.add(this.armarLabelGasNecesario(gasNecesario));

        this.add(contenedor);

    }

    private Component armarLabelTituloCosto() {
        JLabel titulo = new JLabel("Costo:");
        titulo.setForeground(new Color(200,200,20)); Map attributes = titulo.getFont().getAttributes();
        attributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
        titulo.setFont(titulo.getFont().deriveFont(attributes));
        titulo.setOpaque(false);
        return titulo;
    }

    // Para unidades
    public CuadroInformacionRecursos(String cristalNecesario, String gasNecesario, String siministroNecesario){

        this.contenedor = new JPanel(new GridLayout(1,3,0,1));

        this.setUndecorated(true);
        this.getRootPane().setWindowDecorationStyle(JRootPane.NONE);

        this.cargarImagenes();

        this.contenedor.add(this.armarLabelCristaleNecesario(cristalNecesario));
        this.contenedor.add(this.armarLabelGasNecesario(gasNecesario));
        this.contenedor.add(this.armarLabelSuministroNecesario(siministroNecesario));

        this.add(contenedor);

    }

    private void cargarImagenes(){

        try{

            this.imagenes = new BufferedImage[3];
            //String pathCarpetas = "src/vista/auxiliares/jugador/imagenesRecursos/";
            this.imagenes[0] = ImageIO.read(getClass().getResource("iconoMineral.png"));
            this.imagenes[1] = ImageIO.read(getClass().getResource("iconoGasVespeno.png"));
            this.imagenes[2] = ImageIO.read(getClass().getResource("man.jpg"));

            imagenes[0] = cambiarTamanio(imagenes[0], 17, 17); // se cambia el tamanio sin que se pixele
            imagenes[1] = cambiarTamanio(imagenes[1], 17, 17);

        } catch ( IOException e){
            e.printStackTrace();
        }

    }

    private JPanel armarLabelCristaleNecesario(String cristalNecesario){

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
        panel.setOpaque(false);

        JLabel label = new JLabel();
        label.setForeground(new Color(200,200,20));
        label.setIcon(new ImageIcon(imagenes[0]));
        label.setText(cristalNecesario);
        label.setOpaque(false);

        panel.add(label);

        return panel;

    }

    private JPanel armarLabelGasNecesario(String gasNecesario){

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
        panel.setOpaque(false);

        JLabel label = new JLabel();
        label.setForeground(new Color(200,200,20));
        label.setIcon(new ImageIcon(imagenes[1]));
        label.setText(gasNecesario);
        label.setOpaque(false);

        panel.add(label);

        return panel;

    }

    private JLabel armarLabelSuministroNecesario(String suministroNecesario){

        JLabel label = new JLabel();
        label.setIcon(new ImageIcon(imagenes[2]));
        label.setText(suministroNecesario);

        return label;

    }

    private static BufferedImage cambiarTamanio(BufferedImage img, int newW, int newH) {
        Image tmp = img.getScaledInstance(newW, newH, Image.SCALE_SMOOTH);
        BufferedImage dimg = new BufferedImage(newW, newH, BufferedImage.TYPE_INT_ARGB);

        Graphics2D g2d = dimg.createGraphics();
        g2d.drawImage(tmp, 0, 0, null);
        g2d.dispose();

        return dimg;
    }

}

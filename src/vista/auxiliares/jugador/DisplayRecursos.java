package vista.auxiliares.jugador;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.IOException;

public class DisplayRecursos extends JFrame {

    private BufferedImage[] imagenes;
    private JPanel panel;

    public static void main(String[] args){

        DisplayRecursos displayRecursos = new DisplayRecursos();

        displayRecursos.pack();
        displayRecursos.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        displayRecursos.setVisible(true);

    }

    // Metodos ------------------------------

    public DisplayRecursos(){

        this.init();

    }

    private void init(){

        this.panel = new JPanel();
        this.cargarImagenes();

        this.agregarIndicadores();
        this.add(this.panel);

    }

    private void cargarImagenes(){

        try{

            this.imagenes = new BufferedImage[3];
            this.imagenes[0] = ImageIO.read(getClass().getResource("cristal.jpg"));
            //this.imagenes[1] = ImageIO.read(getClass().getResource("resourses/displayRecursos/volcan.jpg"));
            //this.imagenes[2] = ImageIO.read(getClass().getResource("resourses/displayRecursos/man.jpg"));

        } catch ( IOException e){
            e.printStackTrace();
        }

    }

    private void agregarIndicadores(){

        JLabel imagenCristal = new JLabel(new ImageIcon( imagenes[0] ) );
        imagenCristal.setText("Cristal");
        imagenCristal.setSize(20,100);
        this.panel.add(imagenCristal);

    }

}

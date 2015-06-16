package vista;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class DisplayMapa extends JFrame {

    //private BufferedImage[] imagenes;
    private int anchoMapa, altoMapa;
    private JPanel panel;

    public static void main(String[] args){

        DisplayMapa mapa = new DisplayMapa();

        mapa.pack();
        mapa.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        mapa.setVisible(true);

    }

    // Metodos -----

    public DisplayMapa(){

        this.init();

    }

    private void init(){

        this.anchoMapa = 32 ;
        this.altoMapa = 32;
        //this.cargarImagenes();

        this.panel = new JPanel(new GridLayout(this.altoMapa,this.anchoMapa,1,1));
        this.agregarContenidoA(panel);

        this.add(panel);

    }

    private void cargarImagenes(){

        /*try{
            this.imagenes = new BufferedImage[1];
            this.imagenes[0] = ImageIO.read(new ImageIcon("/src/vista/resourses/mapa/grassTiles.png"));
        } catch ( IOException e){
            e.printStackTrace();
        }*/

    }

    private void agregarContenidoA(JPanel panel){

        for (int i = 0; i < this.altoMapa * this.anchoMapa; i++ ){

            JLabel label = new JLabel();
            label.setIcon( new ImageIcon("src/vista/resourses/mapa/grassTiles.png") );
            label.setText("8");
            panel.add(label);

        }

    }

}

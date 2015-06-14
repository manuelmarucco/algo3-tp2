package vista;

import javax.swing.*;
import java.awt.*;

public class DisplayMapa extends JFrame {

    private int anchoMapa, altoMapa;
    private JPanel panel;

    public static void main(String[] args){

        DisplayMapa mapa = new DisplayMapa();

        mapa.pack();
        mapa.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mapa.setVisible(true);

    }

    // Metodos -----

    public DisplayMapa(){

        this.init();

    }

    private void init(){

        this.anchoMapa = 10 ;
        this.altoMapa = 10;

        this.panel = new JPanel(new GridLayout(this.altoMapa,this.anchoMapa,0,0));

        this.agregarContenidoA(panel);

        this.add(panel);

    }

    private void agregarContenidoA(JPanel panel){

        for (int i = 0; i < this.altoMapa * this.anchoMapa; i++ ){

            Label label = new Label("0");
            label.setForeground(Color.WHITE);
            label.setBackground(Color.GREEN);
            panel.add(label);

        }

    }

}

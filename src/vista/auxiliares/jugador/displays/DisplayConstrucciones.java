package vista.auxiliares.jugador.displays;

import javax.swing.*;
import java.awt.*;

public class DisplayConstrucciones extends JPanel {

    private JLayeredPane layeredPane;
    private JPanel botonera;
    private JLabel background;

    public DisplayConstrucciones(){

        this.initBackground();
        this.initLayeredPane();

    }

    private void initBackground() {
        ImageIcon imageBackground = new ImageIcon("images/menu/panelConstrucciones.png");
        this.background = new JLabel(imageBackground);
        this.background.setBounds(0, 0, imageBackground.getIconWidth(), imageBackground.getIconHeight());

    }


    private void initLayeredPane() {
        this.layeredPane = new JLayeredPane();

        this.layeredPane.setPreferredSize(new Dimension(background.getIcon().getIconWidth(),background.getIcon().getIconHeight()));
        this.layeredPane.add(this.background, new Integer(50),0);

        this.add(layeredPane);
    }

    public void agregarBotonera(JPanel botonera) {
        this.botonera = botonera;
        this.botonera.setOpaque(false);
        this.botonera.setBounds( 0, 50,  background.getIcon().getIconWidth(), background.getIcon().getIconHeight());
        this.layeredPane.add(this.botonera, new Integer(100),0);

    }

}
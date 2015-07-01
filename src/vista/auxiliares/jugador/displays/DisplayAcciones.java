package vista.auxiliares.jugador.displays;

import vista.auxiliares.jugador.PanelAcciones;

import javax.swing.*;
import java.awt.*;

public class DisplayAcciones extends JPanel {

    private JLayeredPane layeredPane;
    private JPanel botonera;
    private JLabel background;
    private PanelAcciones panelAcciones;

    public DisplayAcciones(PanelAcciones panelAcciones){

        this.initBackground();
        this.initLayeredPane();
        this.panelAcciones = panelAcciones;
        this.agregarBotonera(panelAcciones);

    }

    private void initBackground() {
        ImageIcon imageBackground = new ImageIcon("images/menu/panelAcciones.png");
        this.background = new JLabel(imageBackground);
        this.background.setBounds(0, 0, imageBackground.getIconWidth(), imageBackground.getIconHeight());

    }


    private void initLayeredPane() {
        this.layeredPane = new JLayeredPane();

        this.layeredPane.setPreferredSize(new Dimension(background.getIcon().getIconWidth(),background.getIcon().getIconHeight()));
        this.layeredPane.add(this.background, new Integer(50),0);

        this.add(layeredPane);
    }

    private void agregarBotonera(JPanel botonera) {
        this.botonera = botonera;
        this.botonera.setOpaque(false);
        this.botonera.setBounds( 0, 25,  background.getIcon().getIconWidth(), background.getIcon().getIconHeight());
        this.layeredPane.add(this.botonera, new Integer(100),0);

    }

    public PanelAcciones getPanelAcciones() {
        return panelAcciones;
    }
}
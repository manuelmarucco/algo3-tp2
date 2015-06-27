package vista.ventanaJugadores;

import javax.swing.*;
import java.awt.*;

public class DisplaySonido extends JPanel {

    private JLayeredPane layeredPane;
    private JPanel panelDeSonido;
    private JLabel background;

    public DisplaySonido(){

        this.initBackground();
        this.initLayeredPane();

    }

    private void initBackground() {
        ImageIcon imageBackground = new ImageIcon("images/menu/panelSonido.png");
        this.background = new JLabel(imageBackground);
        this.background.setBounds(0, 0, imageBackground.getIconWidth(), imageBackground.getIconHeight());

    }


    private void initLayeredPane() {
        this.layeredPane = new JLayeredPane();

        this.layeredPane.setPreferredSize(new Dimension(background.getIcon().getIconWidth(),background.getIcon().getIconHeight()));
        this.layeredPane.add(this.background, new Integer(50),0);

        this.add(layeredPane);
    }

    public void initPanelDeSonido() {
        this.panelDeSonido = new JPanel();
        this.panelDeSonido.setLayout(new BoxLayout(panelDeSonido, BoxLayout.X_AXIS));
        this.panelDeSonido.setOpaque(false);
        this.panelDeSonido.setBounds( 12, 50,  background.getIcon().getIconWidth()-20, background.getIcon().getIconHeight());
        this.layeredPane.add(this.panelDeSonido, new Integer(100),0);

    }
}

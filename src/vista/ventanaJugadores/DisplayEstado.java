package vista.ventanaJugadores;

import javax.swing.*;
import java.awt.*;

public class DisplayEstado extends JPanel {

    private JLayeredPane layeredPane;
    private JPanel panelDeEstado;
    private JLabel background;

    public DisplayEstado(){

        this.initBackground();
        this.initLayeredPane();

    }

    private void initBackground() {
        ImageIcon imageBackground = new ImageIcon("images/menu/panelEstado.png");
        this.background = new JLabel(imageBackground);
        this.background.setBounds(0, 0, imageBackground.getIconWidth(), imageBackground.getIconHeight());

    }


    private void initLayeredPane() {
        this.layeredPane = new JLayeredPane();

        this.layeredPane.setPreferredSize(new Dimension(background.getIcon().getIconWidth(),background.getIcon().getIconHeight()));
        this.layeredPane.add(this.background, new Integer(50),0);

        this.add(layeredPane);
    }

    public void mostrarPanel(JPanel panelDeEstado) {
        this.panelDeEstado = panelDeEstado;
        this.panelDeEstado.setOpaque(false);
        this.panelDeEstado.setBounds( 12, 50,  background.getIcon().getIconWidth()-20, background.getIcon().getIconHeight());
        this.layeredPane.add(this.panelDeEstado, new Integer(100),0);

    }

    public void limpiarPanel(){
        if(this.panelDeEstado != null)
            this.layeredPane.remove(this.panelDeEstado);
    }

    @Override
    public void repaint(){
      if(this.panelDeEstado != null)
            this.panelDeEstado.repaint();
    }
}

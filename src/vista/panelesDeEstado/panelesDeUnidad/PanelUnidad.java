package vista.panelesDeEstado.panelesDeUnidad;

import javax.swing.*;
import java.awt.*;
import java.awt.font.TextAttribute;
import java.util.Map;

public abstract class PanelUnidad extends JPanel {
    protected JPanel panePrincipal;

    protected  JLabel nombre;
    protected JLabel vision;
    protected  JLabel vida;
    protected  JLabel escudo;


    public PanelUnidad(){
        panePrincipal = new JPanel();
        panePrincipal.setLayout(new BoxLayout(panePrincipal, BoxLayout.Y_AXIS));
    }


    protected void crearLabels() {
        nombre = new JLabel();
        vision = new JLabel();
        vida = new JLabel();
        escudo = new JLabel();

    }

    protected void crearPaneles() {

        JPanel panelNombre = new JPanel();
        JPanel panelvision = new JPanel();
        JPanel panelvida = new JPanel();
        JPanel panelescudo = new JPanel();
        JPanel panelTitulo = new JPanel();

        panelNombre.setLayout(new BoxLayout(panelNombre, BoxLayout.X_AXIS));
        panelvision.setLayout(new BoxLayout(panelvision, BoxLayout.X_AXIS));
        panelvida.setLayout(new BoxLayout(panelvida, BoxLayout.X_AXIS));
        panelTitulo.setLayout(new BoxLayout(panelTitulo, BoxLayout.X_AXIS));

        Font font = new Font("Verdana", Font.BOLD, 12);
        Map attributes = font.getAttributes();
        attributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
        nombre.setFont(font.deriveFont(attributes));

        panelNombre.add(nombre);
        panelvision.add(new JLabel("Rango De Vision:  "));
        panelvision.add(vision);
        panelvida.add(new JLabel("Vida:  "));
        panelvida.add(vida);
        panelescudo.add(new JLabel("Escudo:  "));
        panelescudo.add(escudo);

        panePrincipal.add(panelNombre);
        panePrincipal.add(Box.createRigidArea(new Dimension(10, 10)));
        panePrincipal.add(panelvision);
        panePrincipal.add(Box.createRigidArea(new Dimension(10, 10)));
        panePrincipal.add(panelvida);
        panePrincipal.add(Box.createRigidArea(new Dimension(10, 10)));
        panePrincipal.add(panelescudo);

        panelescudo.setVisible(false);


    }

    public void setNombre(String string){
        nombre.setText(string);
    }
    public void setVision(String string){
        vision.setText(string);
    }

    public void setVida(String string){
        vida.setText(string);
    }

    public void setEscudo(String string){
        escudo.setText(string);
        escudo.setVisible(true);
    }

}

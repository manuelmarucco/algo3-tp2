package vista.panelesDeEstado.panelesDeUnidad;

import javax.swing.*;
import java.awt.*;

public abstract class PanelUnidad extends JPanel {
    protected JPanel panel;

    protected  JLabel nombre;
    protected JLabel vision;
    protected  JLabel vida;
    protected  JLabel escudo;


    public PanelUnidad(){
        panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
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

        panelNombre.setLayout(new BoxLayout(panelNombre, BoxLayout.X_AXIS));
        panelvision.setLayout(new BoxLayout(panelvision, BoxLayout.X_AXIS));
        panelvida.setLayout(new BoxLayout(panelvida, BoxLayout.X_AXIS));

        panelNombre.add(new JLabel("Nombre:  "));
        panelNombre.add(nombre);
        panelvision.add(new JLabel("Rango De Vision:  "));
        panelvision.add(vision);
        panelvida.add(new JLabel("Vida:  "));
        panelvida.add(vida);
        panelescudo.add(new JLabel("Escudo:  "));
        panelescudo.add(escudo);

        JTextArea titulo = new JTextArea("Estado de la Unidad");
        titulo.setFont(new Font("Verdana", Font.BOLD, 12));
        titulo.setOpaque(false);

        panel.add(titulo);
        panel.add(Box.createRigidArea(new Dimension(10,30)));
        panel.add(panelNombre);
        panel.add(Box.createRigidArea(new Dimension(10,10)));
        panel.add(panelvision);
        panel.add(Box.createRigidArea(new Dimension(10,10)));
        panel.add(panelvida);
        panel.add(Box.createRigidArea(new Dimension(10,10)));
        panel.add(panelescudo);

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

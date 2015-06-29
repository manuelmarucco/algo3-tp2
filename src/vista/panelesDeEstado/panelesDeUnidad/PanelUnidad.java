package vista.panelesDeEstado.panelesDeUnidad;

import vista.sonido.SonidosDelJuego;

import javax.swing.*;
import java.awt.*;
import java.awt.font.TextAttribute;
import java.util.Map;

public abstract class PanelUnidad extends JPanel {
    protected JPanel panelPrincipal;

    protected  JLabel nombre;
    protected JLabel vision;
    protected  JLabel vida;
    protected  JLabel escudo;

    private  JPanel panelEscudo;


    public PanelUnidad(){
        panelPrincipal = new JPanel();
        panelPrincipal.setLayout(new BoxLayout(panelPrincipal, BoxLayout.Y_AXIS));
        panelPrincipal.setOpaque(false);
        SonidosDelJuego.getInstance().reproducirSeleccionarUnidad();
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
        JLabel tituloVida = new JLabel("Vida:");
        JLabel tituloEscudo = new JLabel("Escudo:");
        JLabel tituloVision = new JLabel("Rango De Vision:");

        panelNombre.setLayout(new BoxLayout(panelNombre, BoxLayout.X_AXIS));
        panelNombre.setOpaque(false);
        panelvision.setLayout(new BoxLayout(panelvision, BoxLayout.X_AXIS));
        panelvision.setOpaque(false);
        panelvida.setLayout(new BoxLayout(panelvida, BoxLayout.X_AXIS));
        panelvida.setOpaque(false);
        panelescudo.setLayout(new BoxLayout(panelescudo, BoxLayout.X_AXIS));
        panelescudo.setOpaque(false);

        this.setearFuenteDeJLabel(nombre,true,Font.BOLD,14);
        this.setearFuenteDeJLabel(tituloVida,true,Font.BOLD,12);
        this.setearFuenteDeJLabel(tituloEscudo,true,Font.BOLD,12);
        this.setearFuenteDeJLabel(tituloVision,true,Font.BOLD,12);

        panelNombre.add(nombre);
        panelvision.add(tituloVision);
        panelvision.add(vision);
        vision.setForeground(new Color(200,200,20));
        panelvida.add(tituloVida);
        panelvida.add(vida);
        vida.setForeground(new Color(200,200,20));
        panelescudo.add(tituloEscudo);
        escudo.setForeground(new Color(200,200,20));
        panelescudo.add(escudo);

        panelPrincipal.add(panelNombre);
        panelPrincipal.add(Box.createRigidArea(new Dimension(10,10)));
        panelPrincipal.add(Box.createRigidArea(new Dimension(10,10)));
        panelPrincipal.add(panelvision);
        panelPrincipal.add(Box.createRigidArea(new Dimension(10, 10)));
        panelPrincipal.add(panelvida);
        panelPrincipal.add(Box.createRigidArea(new Dimension(10, 10)));
        panelPrincipal.add(panelescudo);

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
        panelEscudo.setVisible(true);
    }

    protected void setearFuenteDeJLabel(JLabel label,boolean underline,int fontType,int fontSize){

        Font font = new Font("Verdana", fontType, fontSize);
        if(underline){
            Map attributes = font.getAttributes();
            attributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
            label.setFont(font.deriveFont(attributes));
        }
        label.setForeground(new Color(200,200,20));

    }
}

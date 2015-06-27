package vista.panelesDeEstado.panelesDeConstruccion;

import javax.swing.*;
import java.awt.*;
import java.awt.font.TextAttribute;
import java.util.Map;

public class PanelConstruccion extends JPanel {
    protected JPanel panelPrincipal;

    protected  JLabel nombre;
    protected  JLabel vida;
    protected  JLabel escudo;

    private JPanel panelEscudo;


    public PanelConstruccion(){
        panelPrincipal = new JPanel();
        panelPrincipal.setLayout(new BoxLayout(panelPrincipal, BoxLayout.Y_AXIS));
        panelPrincipal.setOpaque(false);

        this.crearLabels();
        this.crearPaneles();
        this.add(panelPrincipal);
    }


    protected void crearLabels() {
        nombre = new JLabel();
        vida = new JLabel();
        escudo = new JLabel();

    }

    protected void crearPaneles() {

        JPanel panelNombre = new JPanel();
        JPanel panelvida = new JPanel();
        panelEscudo = new JPanel();
        JLabel tituloVida = new JLabel("Vida:");
        JLabel tituloEscudo = new JLabel("Escudo:");

        panelNombre.setLayout(new BoxLayout(panelNombre, BoxLayout.X_AXIS));
        panelNombre.setOpaque(false);
        panelvida.setLayout(new BoxLayout(panelvida, BoxLayout.X_AXIS));
        panelvida.setOpaque(false);
        panelEscudo.setLayout(new BoxLayout(panelEscudo, BoxLayout.X_AXIS));
        panelEscudo.setOpaque(false);

        this.setearFuenteDeJLabel(nombre,true,Font.BOLD,13);
        this.setearFuenteDeJLabel(tituloVida,true,Font.BOLD,12);
        this.setearFuenteDeJLabel(tituloEscudo,true,Font.BOLD,12);

        panelNombre.add(nombre);
        panelvida.add(tituloVida);
        vida.setForeground(new Color(200,200,20));
        panelvida.add(vida);
        panelEscudo.add(tituloEscudo);
        escudo.setForeground(new Color(200,200,20));
        panelEscudo.add(escudo);

        panelPrincipal.add(panelNombre);
        panelPrincipal.add(Box.createRigidArea(new Dimension(10, 10)));
        panelPrincipal.add(Box.createRigidArea(new Dimension(10, 10)));
        panelPrincipal.add(panelvida);
        panelPrincipal.add(Box.createRigidArea(new Dimension(10, 10)));
        panelPrincipal.add(panelEscudo);
        panelPrincipal.add(Box.createRigidArea(new Dimension(10, 10)));

        panelEscudo.setVisible(false);


    }

    public void cargarNombre(String string){
        nombre.setText(string);
    }

    public void cargarVida(String string){
        vida.setText(string);
    }

    public void cargarEscudo(String string){
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

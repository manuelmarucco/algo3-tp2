package vista.panelesDeEstado.panelesDeConstruccion;

import javax.swing.*;
import java.awt.*;

public abstract class PanelConstruccion extends JPanel {
    protected JPanel panelPrincipal;

    protected  JLabel nombre;
    protected  JLabel vida;
    protected  JLabel escudo;


    public PanelConstruccion(){
        panelPrincipal = new JPanel();
        panelPrincipal.setLayout(new BoxLayout(panelPrincipal, BoxLayout.Y_AXIS));
    }


    protected void crearLabels() {
        nombre = new JLabel();
        vida = new JLabel();
        escudo = new JLabel();

    }

    protected void crearPaneles() {

        JPanel panelNombre = new JPanel();
        JPanel panelvida = new JPanel();
        JPanel panelescudo = new JPanel();
        JPanel panelTitulo = new JPanel();

        panelNombre.setLayout(new BoxLayout(panelNombre, BoxLayout.X_AXIS));
        panelvida.setLayout(new BoxLayout(panelvida, BoxLayout.X_AXIS));
        panelescudo.setLayout(new BoxLayout(panelescudo, BoxLayout.X_AXIS));
        panelTitulo.setLayout(new BoxLayout(panelTitulo, BoxLayout.X_AXIS));

        panelNombre.add(new JLabel("Nombre:  "));
        panelNombre.add(nombre);
        panelvida.add(new JLabel("Vida:  "));
        panelvida.add(vida);
        panelescudo.add(new JLabel("Escudo:  "));
        panelescudo.add(escudo);

        JLabel titulo = new JLabel("Estado de la Construccion");
        titulo.setFont(new Font("Verdana", Font.BOLD, 12));
        titulo.setOpaque(false);
        panelTitulo.add(titulo);

        panelPrincipal.add(panelTitulo);
        panelPrincipal.add(Box.createRigidArea(new Dimension(10, 10)));
        panelPrincipal.add(panelNombre);
        panelPrincipal.add(Box.createRigidArea(new Dimension(10, 10)));
        panelPrincipal.add(panelvida);
        panelPrincipal.add(Box.createRigidArea(new Dimension(10, 10)));
        panelPrincipal.add(panelescudo);

        panelescudo.setVisible(false);


    }

    public void cargarNombre(String string){
        nombre.setText(string);
    }

    public void cargarVida(String string){
        vida.setText(string);
    }

    public void cargarEscudo(String string){
        escudo.setText(string);
        escudo.setVisible(true);
    }


}

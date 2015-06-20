package vista.panelesDeEstado.panelesDeUnidad;

import javax.swing.*;

public abstract class PanelUnidad extends JPanel {
    protected JPanel panel;

    protected  JLabel nombre;
    protected JLabel vision;
    protected  JLabel vida;


    public PanelUnidad(){
        panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
    }


    protected void crearLabels() {
        nombre = new JLabel();
        vision = new JLabel();
        vida = new JLabel();

    }

    protected void crearPaneles() {

        JPanel panelNombre = new JPanel();
        JPanel panelvision = new JPanel();
        JPanel panelvida = new JPanel();

        panelNombre.setLayout(new BoxLayout(panelNombre, BoxLayout.X_AXIS));
        panelvision.setLayout(new BoxLayout(panelvision, BoxLayout.X_AXIS));
        panelvida.setLayout(new BoxLayout(panelvida, BoxLayout.X_AXIS));

        panelNombre.add(new JLabel("Nombre:  "));
        panelNombre.add(nombre);
        panelvision.add(new JLabel("Rango De Vision:  "));
        panelvision.add(vision);
        panelvida.add(new JLabel("Vida:  "));
        panelvida.add(vida);

        panel.add(panelNombre);
        panel.add(panelvision);
        panel.add(panelvida);

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

}

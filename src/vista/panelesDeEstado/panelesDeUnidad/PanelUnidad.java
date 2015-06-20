package vista.panelesDeEstado.panelesDeUnidad;

import javax.swing.*;

public class PanelUnidad extends JPanel {
    JPanel panel;
    JTextArea Nombre;
    JTextArea DanioTerrestre;
    JTextArea DanioAereo;
    JTextArea RangoAtaque;
    JTextArea Vision;
    JTextArea Vida;

    public PanelUnidad(){
        panel = new JPanel();
        panel.add(new JTextArea("Nombre:"));
        panel.add(new JTextArea("DanioTerrestre:"));
    }

}

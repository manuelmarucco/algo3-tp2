package vista.panelesDeEstado.panelesDeUnidad;

import javax.swing.*;
import java.awt.*;

public class PanelUnidadMagica extends PanelUnidad {
    private JLabel energiaActual;
    private JLabel energiaTotal;


    public PanelUnidadMagica() {
        this.crearLabels();
        this.crearPaneles();

        this.add(panePrincipal);

    }

    @Override
    protected void crearLabels() {
        super.crearLabels();
        energiaActual = new JLabel();
        energiaTotal = new JLabel();

    }

    @Override
    protected void crearPaneles() {
        super.crearPaneles();
        JPanel panelenergiaActual = new JPanel();
        JPanel panelenergiaTotal = new JPanel();

        panelenergiaActual.setLayout(new BoxLayout(panelenergiaActual, BoxLayout.X_AXIS));
        panelenergiaTotal.setLayout(new BoxLayout(panelenergiaTotal, BoxLayout.X_AXIS));


        panelenergiaActual.add(new JLabel("Energia Actual:  "));
        panelenergiaActual.add(energiaActual);


        panelenergiaTotal.add(new JLabel("Energia Total:  "));
        panelenergiaTotal.add(energiaTotal);


        panePrincipal.add(panelenergiaActual);
        panePrincipal.add(Box.createRigidArea(new Dimension(10,10)));
        panePrincipal.add(panelenergiaTotal);
        panePrincipal.add(Box.createRigidArea(new Dimension(10,10)));

    }

    public void setEnergiaActual(String string) {
        energiaActual.setText(string);
    }

    public void setEnergiaTotal(String string) {
        energiaTotal.setText(string);
    }
}

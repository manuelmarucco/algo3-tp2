package vista.panelesDeEstado.panelesDeUnidad;

import javax.swing.*;

public class PanelUnidadMagica extends PanelUnidad {
    private JLabel energiaActual;
    private JLabel energiaTotal;


    public PanelUnidadMagica() {
        this.crearLabels();
        this.crearPaneles();

        this.add(panel);

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


        panel.add(panelenergiaActual);
        panel.add(panelenergiaTotal);

    }

    public void setEnergiaActual(String string) {
        energiaActual.setText(string);
    }

    public void setEnergiaTotal(String string) {
        energiaTotal.setText(string);
    }
}

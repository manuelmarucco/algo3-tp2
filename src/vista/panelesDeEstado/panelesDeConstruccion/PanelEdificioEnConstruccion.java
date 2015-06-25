package vista.panelesDeEstado.panelesDeConstruccion;

import javax.swing.*;
import java.awt.*;

public class PanelEdificioEnConstruccion extends PanelConstruccion {
    private JPanel panelTiempoDeConstruccion;



    public PanelEdificioEnConstruccion(){
        this.crearLabels();
        this.crearPaneles();

        this.add(panelPrincipal);

    }


    @Override
    protected void crearLabels() {
        super.crearLabels();

    }

    @Override
    protected void crearPaneles() {
        super.crearPaneles();

        this.crearPanelTiempoDeConstruccion();


    }

    private void crearPanelTiempoDeConstruccion() {
        panelTiempoDeConstruccion = new JPanel();

        panelTiempoDeConstruccion.setLayout(new BoxLayout(panelTiempoDeConstruccion, BoxLayout.X_AXIS));
        panelTiempoDeConstruccion.add(new JLabel("Turnos para terminar la construccion"));

        panelPrincipal.add(panelTiempoDeConstruccion);
    }

    public void mostrarTiempoDeConstruccion(int tiempoDeConstruccionActual, int tiempoDeConstruccionTotal){
        JProgressBar progressTiempoDeConstruccion = new JProgressBar(0,tiempoDeConstruccionTotal);
        progressTiempoDeConstruccion.setPreferredSize(new Dimension(190,20));
        progressTiempoDeConstruccion.setMaximumSize(new Dimension(190, 20));
        progressTiempoDeConstruccion.setValue(tiempoDeConstruccionTotal-tiempoDeConstruccionActual);
        progressTiempoDeConstruccion.setStringPainted(true);
        progressTiempoDeConstruccion.setVisible(true);

        progressTiempoDeConstruccion.setString(String.valueOf(tiempoDeConstruccionActual)+" turnos para finalizar");
        panelPrincipal.add(Box.createRigidArea(new Dimension(10, 10)));
        panelPrincipal.add(progressTiempoDeConstruccion);
    }

}
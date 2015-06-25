package vista.panelesDeEstado.panelesDeConstruccion;

import javax.swing.*;
import java.awt.*;

public class PanelEdificioEnConstruccion extends PanelConstruccion {

    private  JProgressBar progressTiempoDeConstruccion;
    private JPanel panelTiempoDeConstruccion;



    public PanelEdificioEnConstruccion(){
        this.crearLabels();
        this.crearPaneles();

        this.add(panel);

    }


    @Override
    protected void crearLabels() {
        super.crearLabels();

    }

    @Override
    protected void crearPaneles() {
        super.crearPaneles();

        panelTiempoDeConstruccion = new JPanel();

        panelTiempoDeConstruccion.setLayout(new BoxLayout(panelTiempoDeConstruccion, BoxLayout.X_AXIS));

        panelTiempoDeConstruccion.add(new JLabel("Turnos para terminar la construccion"));

        panel.add(panelTiempoDeConstruccion);


    }

    public void setTiempoDeConstruccion(int tiempoDeConstruccionActual,int tiempoDeConstruccionTotal){
        progressTiempoDeConstruccion = new JProgressBar(0,tiempoDeConstruccionTotal);
        progressTiempoDeConstruccion.setPreferredSize(new Dimension(190,20));
        progressTiempoDeConstruccion.setMaximumSize(new Dimension(190, 20));
        progressTiempoDeConstruccion.setValue(tiempoDeConstruccionTotal-tiempoDeConstruccionActual);
        progressTiempoDeConstruccion.setStringPainted(true);
        progressTiempoDeConstruccion.setVisible(true);

        progressTiempoDeConstruccion.setString(String.valueOf(tiempoDeConstruccionActual)+" turnos para finalizar");
        panel.add(Box.createRigidArea(new Dimension(10, 10)));
        panel.add(progressTiempoDeConstruccion);
    }

}
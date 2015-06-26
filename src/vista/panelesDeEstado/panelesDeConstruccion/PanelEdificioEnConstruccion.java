package vista.panelesDeEstado.panelesDeConstruccion;

import construcciones.EdificioEnConstruccion;

import javax.swing.*;
import java.awt.*;

public class PanelEdificioEnConstruccion extends PanelConstruccion {
    private JPanel panelTiempoDeConstruccion;
    private EdificioEnConstruccion edificio;



    public PanelEdificioEnConstruccion(){
        this.inicializarPanelesPadre();
    }


    private void inicializarPanelesPadre(){
        super.crearLabels();
        super.crearPaneles();
        this.add(panelPrincipal);
    }

    private void crearPanelTiempoDeConstruccion() {
        panelTiempoDeConstruccion = new JPanel();

        panelTiempoDeConstruccion.setLayout(new BoxLayout(panelTiempoDeConstruccion, BoxLayout.X_AXIS));
        panelTiempoDeConstruccion.add(new JLabel("Turnos para terminar la construccion"));

        panelPrincipal.add(panelTiempoDeConstruccion);
    }

    public void mostrarTiempoDeConstruccion(int tiempoDeConstruccionActual, int tiempoDeConstruccionTotal){
        this.crearPanelTiempoDeConstruccion();

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

    public void cargarDatosDeEdificioEnConstruccion(EdificioEnConstruccion edificioEnConstruccion){
        this.edificio = edificioEnConstruccion;
        this.cargarNombre(edificio.getEdificioAConvertirse().getClass().getSimpleName());
        this.cargarVida(String.valueOf(edificio.getEdificioAConvertirse().getVida()));
        this.mostrarTiempoDeConstruccion(edificio.getTiempoDeConstruccionActual(), edificio.getEdificioAConvertirse().getTiempoDeConstruccion());

    }

    @Override
    public void repaint(){
        if(edificio!= null) {
            this.panelPrincipal.removeAll();
            this.crearLabels();
            this.crearPaneles();
            this.add(panelPrincipal);
            this.cargarDatosDeEdificioEnConstruccion(this.edificio);
        }
    }

}
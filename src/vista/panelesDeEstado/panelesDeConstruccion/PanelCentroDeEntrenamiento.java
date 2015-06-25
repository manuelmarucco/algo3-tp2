package vista.panelesDeEstado.panelesDeConstruccion;

import interfaces.Entrenable;

import javax.swing.*;
import java.util.Queue;

public class PanelCentroDeEntrenamiento extends PanelConstruccion {
    protected  JLabel colaDeEntrenamiento;


    public PanelCentroDeEntrenamiento(){
        this.crearLabels();
        this.crearPaneles();

        this.add(panel);
    }


    @Override
    protected void crearLabels() {
        super.crearLabels();
        colaDeEntrenamiento = new JLabel();

    }

    @Override
    protected void crearPaneles() {
        super.crearPaneles();

        JPanel panelColaDeEntrenamiento = new JPanel();

        panelColaDeEntrenamiento.setLayout(new BoxLayout(panelColaDeEntrenamiento, BoxLayout.X_AXIS));

        panelColaDeEntrenamiento.add(new JLabel("Cola de Entrenamiento"));
        panelColaDeEntrenamiento.add(colaDeEntrenamiento);



    }


    public void setColaDeEntrenamiento(Queue<Entrenable> colaDeEntrenamiento) {

        for(Entrenable unidad: colaDeEntrenamiento){

            this.colaDeEntrenamiento.setText(this.colaDeEntrenamiento.getText()+"-"+unidad.getClass().getSimpleName());
        }
    }
}

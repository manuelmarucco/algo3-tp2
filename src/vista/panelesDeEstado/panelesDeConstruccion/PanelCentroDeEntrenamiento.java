package vista.panelesDeEstado.panelesDeConstruccion;

import interfaces.Entrenable;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import java.awt.*;
import java.util.Queue;

public class PanelCentroDeEntrenamiento extends PanelConstruccion {
    private  JTree treeColaDeEntrenamiento;
    private DefaultMutableTreeNode root;
    private JPanel panelTiempoDeEntrenamientoDeUnidad;


    public PanelCentroDeEntrenamiento(){
        super.crearLabels();
        super.crearPaneles();

        this.add(panelPrincipal);
    }

/*
    @Override
    protected void crearLabels() {
        super.crearLabels();
        //this.crearTreeColaDeEntrenamiento();

    }


    @Override
    protected void crearPaneles() {
        super.crearPaneles();

        //this.crearPanelColaDeEntrenamiento();
        //this.crearPanelTiempoDeEntrenamientoDeUnidad();

    }
*/

    public void mostrarColaDeEntrenamiento(Queue<Entrenable> colaDeEntrenamiento) {
        if(colaDeEntrenamiento.size() == 0) return;

        this.crearTreeColaDeEntrenamiento(colaDeEntrenamiento);
        this.mostrarTiempoDeEntrenamiento(colaDeEntrenamiento.peek());

        for(Entrenable unidad: colaDeEntrenamiento){
            root.add(new DefaultMutableTreeNode(unidad.getClass().getSimpleName()));
        }
    }

    private void crearTreeColaDeEntrenamiento(Queue<Entrenable> colaDeEntrenamiento) {
        root = new DefaultMutableTreeNode(String.valueOf(colaDeEntrenamiento.size())+" unidad/s en Cola de Entrenamiento");
        treeColaDeEntrenamiento = new JTree(root);
        treeColaDeEntrenamiento.setOpaque(false);
        treeColaDeEntrenamiento.setPreferredSize(new Dimension(100,20));


        JScrollPane panelColaDeEntrenamiento = new JScrollPane(treeColaDeEntrenamiento);
        panelColaDeEntrenamiento.setPreferredSize(new Dimension(170,60));
        this.panelPrincipal.add(panelColaDeEntrenamiento);

        //TODO no logré hacer que sea scrolleable
    }

    public void mostrarTiempoDeEntrenamiento(Entrenable unidad){
        int tiempoDeEntrenamientoTotal = unidad.getTiempoDeEntrenamientoTotal();
        int tiempoDeEntrenamientoActual = unidad.getTiempoDeEntrenamientoActual();

        this.crearLabelDeUnidadEnEntrenamiento(unidad.getClass().getSimpleName());

        JProgressBar progressTiempoDeEntrenamiento = new JProgressBar(0,tiempoDeEntrenamientoTotal);
        progressTiempoDeEntrenamiento.setPreferredSize(new Dimension(190, 20));
        progressTiempoDeEntrenamiento.setMaximumSize(new Dimension(190, 20));
        progressTiempoDeEntrenamiento.setValue(tiempoDeEntrenamientoTotal - tiempoDeEntrenamientoActual);
        progressTiempoDeEntrenamiento.setStringPainted(true);
        progressTiempoDeEntrenamiento.setVisible(true);

        progressTiempoDeEntrenamiento.setString(String.valueOf(tiempoDeEntrenamientoActual) + " turnos para finalizar");
        this.panelPrincipal.add(Box.createRigidArea(new Dimension(10, 10)));
        this.panelPrincipal.add(progressTiempoDeEntrenamiento);
    }


    private void crearLabelDeUnidadEnEntrenamiento(String nombreDeUnidad) {
        panelTiempoDeEntrenamientoDeUnidad = new JPanel();

        panelTiempoDeEntrenamientoDeUnidad.setLayout(new BoxLayout(panelTiempoDeEntrenamientoDeUnidad, BoxLayout.X_AXIS));
        panelTiempoDeEntrenamientoDeUnidad.add(new JLabel("Entrenando "+nombreDeUnidad+"..."));

        this.panelPrincipal.add(Box.createRigidArea(new Dimension(10, 10)));
        this.panelPrincipal.add(panelTiempoDeEntrenamientoDeUnidad);

    }


}
